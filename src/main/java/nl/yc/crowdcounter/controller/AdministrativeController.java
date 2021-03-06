package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.PermissionCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.ModifyUserPermissionData;
import nl.yc.crowdcounter.model.Permission;
import nl.yc.crowdcounter.model.User;
import nl.yc.crowdcounter.util.BCrypt;
import nl.yc.crowdcounter.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
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
    @Accessibility(requiredPermissions = {"add_user"})
    public String createAccountView() {
        return "createUser";
    }

    @RequestMapping(value = "/admin.createAccount", method = RequestMethod.POST)
    @Accessibility(requiredPermissions = {"add_user"})
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
            request.getSession().setAttribute("success", "New user successfully added!");
        } catch(DataIntegrityViolationException dive) {
            request.getSession().setAttribute("error", "Username already exists!");
        }

        return "redirect:/admin.createAccount";
    }

    @RequestMapping(value = "/admin.modifyUser.fetchuser", method = RequestMethod.POST)
    @Accessibility(requiredPermissions = {"modify_user"})
    @ResponseBody
    public String modifyUserView(@RequestParam String name) {
        if (name.equals("SomeRandomGibberishToFilter"))
            return "<div href=\"\" class=\"list-group-item\"><p class=\"list-group-item-text\">No results found!</p></div>";

        StringBuilder sb = new StringBuilder();
        Set<User> users = userRepo.findAllByNameContaining(name);

        if (users.size() == 0 || users.isEmpty())
            return "<div href=\"\" class=\"list-group-item\"><p class=\"list-group-item-text\">No results found!</p></div>";

        for (User u : users) {
            sb.append("<a href=\"/admin.modifyUser.").append(u.getId()).append("\" class=\"list-group-item\">")
                    .append("<p class=\"list-group-item-text\">").append(u.getName()).append("</p>").append("</a>");
        }

        return sb.toString();
    }

    @RequestMapping(value = "/admin.modifyUser.select", method = RequestMethod.GET)
    @Accessibility(requiredPermissions = {"modify_user"})
    public String modifyUserView() {
        return "selectUser";
    }

    @RequestMapping(value = "/admin.modifyUser.{id}", method = RequestMethod.GET)
    @Accessibility(requiredPermissions = {"modify_user"})
    public String modifyUserSelectedView(Model model, @PathVariable String id) {
        long uid = 0;

        try {
            uid = Long.parseLong(id);
        } catch (NumberFormatException nfe) {
            model.addAttribute("error", Util.build("Value ", id, " is not a number!"));
            return "modifyUser";
        }

        User u = userRepo.findOne(uid);

        if (u != null) {
            model.addAttribute("target_user", u);
            model.addAttribute("permissions_Table", permRepo.findAll());
        } else {
            model.addAttribute("error", "User does not exist in the database!");
        }

        return "modifyUser";
    }

    @RequestMapping(value = "/admin.createPerm", method = RequestMethod.GET)
    @Accessibility(requiredPermissions = {"create_perm"})
    public String createPermission(Model m) {
        m.addAttribute("permissions_Table", permRepo.findAll());

        return "createPerm";
    }

    @RequestMapping(value = "/admin.createPerm", method = RequestMethod.POST)
    @Accessibility(requiredPermissions = {"create_perm"})
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
            request.getSession().setAttribute("success", "Added new permission to the database!");
        } catch (DataIntegrityViolationException dive) {
            request.getSession().setAttribute("error", "Permission already exists in the database!");
        }

        return "redirect:/admin.createPerm";
    }

    @RequestMapping(value = "/admin.modifyUser.updatePerm", method = RequestMethod.POST)
    @Accessibility(requiredPermissions = {"modify_user"})
    @ResponseBody
    public void modifyUserUpdatePerm(@RequestBody ModifyUserPermissionData data) {
        Set<Permission> newPerms = new HashSet<>();

        for (Permission perm : permRepo.findAll()) {
            if (data.getPerms().contains(new Long(perm.getId()))) newPerms.add(perm);
        }

        User u = userRepo.findOne(data.getUid());

        u.setPermissions(newPerms);
        userRepo.save(u);
    }
}
