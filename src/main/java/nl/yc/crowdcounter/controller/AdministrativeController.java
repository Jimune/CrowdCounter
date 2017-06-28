package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.BCrypt;
import nl.yc.crowdcounter.crudrepositories.PermissionCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.LoginSession;
import nl.yc.crowdcounter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

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

    @RequestMapping(value = "/admin.modifyUser", method = RequestMethod.GET)
    @Accessibility(requireLogin = true, requiredPermissions = {"modify_user"})
    public String modifyUserView(HttpServletRequest request, Model model) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        model.addAttribute("error", request.getSession().getAttribute("error"));
        request.getSession().setAttribute("error", null);

        return "modifyUser";
    }
}
