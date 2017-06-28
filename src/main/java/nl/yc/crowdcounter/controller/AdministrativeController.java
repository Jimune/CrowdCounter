package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.PermissionCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.User;
import nl.yc.crowdcounter.util.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
    public List<User> modifyUserView(@RequestParam(defaultValue = "SomeRandomGibberishToFilter") String name) {
        List<User> temp = new ArrayList<User>();

        if (name.equals("SomeRandomGibberishToFilter")) return temp;

        for (User u : userRepo.findAllLikeName(name)) temp.add(u);
        return temp;
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
    public String modifyUserSelectedView(HttpServletRequest request, Model model, @RequestParam String id) {
        model.addAttribute("user", request.getSession().getAttribute("user"));

        User u = userRepo.findOne(Long.parseLong(id));

        if (u != null) {
            model.addAttribute("target_user", u);
            model.addAttribute("permissions_Table", permRepo.findAll());
        } else {
            model.addAttribute("error", "User does not exist in the database!");
        }

        request.getSession().setAttribute("error", null);

        return "selectUser";
    }

}
