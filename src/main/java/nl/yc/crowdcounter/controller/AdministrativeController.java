package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.PermissionCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.Permission;
import nl.yc.crowdcounter.model.User;
import nl.yc.crowdcounter.util.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * Created by jim on 6/26/17.
 */
@Controller
public class AdministrativeController {

    @Autowired
    UserCrudRepo userRepo;
    @Autowired
    PermissionCrudRepo permRepo;

    @RequestMapping(value = "/admin.createAccount", method = RequestMethod.GET)
    @Accessibility(requireLogin = true, requiredPermissions = {"add_user"})
    public String createAccountView(HttpServletRequest request, Model model) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        model.addAttribute("error", request.getSession().getAttribute("error"));
        request.getSession().setAttribute("error", null);

        return "createUser";
    }

    @RequestMapping(value = "/admin.createAccount", method = RequestMethod.POST)
    @Accessibility(requireLogin = true, requiredPermissions = {"add_user"})
    public String createAccountHandle(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        String passconf = request.getParameter("confpass");

        if (name == null || name.isEmpty()
                || pass == null || pass.isEmpty()
                || passconf == null || passconf.isEmpty()) {
            request.getSession().setAttribute("error", "Please fill in all fields!");

            return "redirect:/admin.createAccount";
        } else if (!pass.equals(passconf)) {
            request.getSession().setAttribute("error", "Passwords do not match!");

            return "redirect:/admin.createAccount";
        }

        User u = new User();
        u.setName(name);
        u.setHash(BCrypt.hashpw(pass, BCrypt.gensalt()));

        try {
            userRepo.save(u);
            request.getSession().setAttribute("error", "New user successfully added!");
        } catch(DataIntegrityViolationException dive) {
            request.getSession().setAttribute("error", "Username already exists!");
        }

        return "redirect:/admin.createAccount";
    }

    @RequestMapping(value = "/admin.modifyUser.fetchuser", method = RequestMethod.POST)
    @Accessibility(requireLogin = true, requiredPermissions = {"modify_user"})
    @ResponseBody
    public String modifyUserView(@RequestParam String name) {
        System.out.println("method pinged: " + name);

        if (name.equals("SomeRandomGibberishToFilter")) return "<tr><td>No results found!</td></tr>";

        StringBuilder sb = new StringBuilder();
        Set<User> users = userRepo.findAllByNameContaining(name);

        if (users.size() == 0 || users.isEmpty()) return "<tr><td>No results found!</td></tr>";

        for (User u : users) {
            sb.append("<tr><td><a href=\"/admin.modifyUser.").append(u.getId()).append("\">")
                    .append(u.getName()).append("</a></td></tr>");
        }

        return sb.toString();
    }

    @RequestMapping(value = "/admin.modifyUser.select", method = RequestMethod.GET)
    @Accessibility(requireLogin = true, requiredPermissions = {"modify_user"})
    public String modifyUserView(HttpServletRequest request, Model model) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        model.addAttribute("error", request.getSession().getAttribute("error"));
        request.getSession().setAttribute("error", null);

        return "selectUser";
    }

    @RequestMapping(value = "/admin.modifyUser.{id}", method = RequestMethod.GET)
    @Accessibility(requireLogin = true, requiredPermissions = {"modify_user"})
    public String modifyUserSelectedView(HttpServletRequest request, Model model, @PathVariable String id) {
        model.addAttribute("user", request.getSession().getAttribute("user"));

        User u = userRepo.findOne(Long.parseLong(id));

        if (u != null) {
            model.addAttribute("target_user", u);
            model.addAttribute("permissions_Table", permRepo.findAll());
        } else {
            model.addAttribute("error", "User does not exist in the database!");
        }

        request.getSession().setAttribute("error", null);

        return "modifyUser";
    }

    @RequestMapping(value = "/admin.createPerm", method = RequestMethod.GET)
    @Accessibility(requireLogin = true, requiredPermissions = {"create_perm"})
    public String createPermission(HttpServletRequest request, Model m) {
        m.addAttribute("user", request.getSession().getAttribute("user"));
        m.addAttribute("error", request.getSession().getAttribute("error"));
        m.addAttribute("permissions_Table", permRepo.findAll());

        request.getSession().setAttribute("error", null);

        return "createPerm";
    }

    @RequestMapping(value = "/admin.createPerm", method = RequestMethod.POST)
    @Accessibility(requireLogin = true, requiredPermissions = {"create_perm"})
    public String createPermissionHandle(HttpServletRequest request) {
        String perm = request.getParameter("perm");
        String desc = request.getParameter("desc");

        if (perm == null || perm.isEmpty()
                || desc == null || desc.isEmpty()) {
            request.getSession().setAttribute("error", "Please fill in all fields!");
            return "redirect:/admin.createPerm";
        }

        Permission p = new Permission();
        p.setDescription(desc);
        p.setPermission(perm);

        try {
            permRepo.save(p);
            request.getSession().setAttribute("error", "Added new permission to the database!");
        } catch (DataIntegrityViolationException dive) {
            request.getSession().setAttribute("error", "Permission already exists in the database!");
        }

        return "redirect:/admin.createPerm";
    }

    @RequestMapping(value = "/admin.modifyUser.updatePerm", method = RequestMethod.POST)
    @Accessibility(requireLogin = true, requiredPermissions = {"modify_user"})
    @ResponseBody
    public String modifyUserUpdatePerm(@RequestParam String user, @RequestParam String perm, @RequestParam String enabled) {
        System.out.println("method pinged: " + user + " - " + perm + " - " + enabled);

        long uid = 0;
        long pid = 0;
        boolean add = Boolean.parseBoolean(enabled);

        try {
            uid = Long.parseLong(user);
            pid = Long.parseLong(perm);
        } catch (NumberFormatException nfe) {
        }

        if (uid == 0 || pid == 0) {
            if (add) return "Error adding permission to user! User ID or Permission ID is invalid!";
            else return "Error removing permission to user! User ID or Permission ID is invalid!";
        }

        User u = userRepo.findOne(uid);

        if (u == null) return "Error, no user with this User ID exists!";

        Set<Permission> permissions = u.getPermissions();

        if (add) {
            permissions.add(permRepo.findOne(pid));
        } else {
            Permission toRemove = null;

            for (Permission permission : permRepo.findAll()) {
                if (permission.getId() == pid) {
                    toRemove = permission;
                    break;
                }
            }

            if (toRemove == null)
                return "Error, user does not have a permission with this ID or the permission does not exist!";

            permissions.remove(toRemove);
        }

        u.setPermissions(permissions);
        userRepo.save(u);

        return add ? "Permission successfully added!" : "Permission successfully removed!";
    }
}
