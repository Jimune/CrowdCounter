package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.User;
import nl.yc.crowdcounter.util.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jim on 6/27/17.
 */
@Controller
public class AccountController {

    @Autowired
    UserCrudRepo userRepo;

    @RequestMapping(value = "/account.changePassword", method = RequestMethod.GET)
    @Accessibility(requiredPermissions = {"change_pass"})
    public String changePassView() {
        return "changePassword";
    }

    @RequestMapping(value = "/account.changePassword", method = RequestMethod.POST)
    @Accessibility(requiredPermissions = {"change_pass"})
    public String changePassView(HttpServletRequest request) {
        String origPass = request.getParameter("origPass");
        String newPass = request.getParameter("newPass");
        String repPass = request.getParameter("repeatPass");

        if (origPass == null || origPass.isEmpty()
                || newPass == null || newPass.isEmpty()
                || repPass == null || repPass.isEmpty()) {
            request.getSession().setAttribute("error", "Please fill in all fields!");
            return "redirect:/account.changePassword";
        }

        if (!newPass.equals(repPass)) {
            request.getSession().setAttribute("error", "New passwords do no match!");
            return "redirect:/account.changePassword";
        }

        if (origPass.equals(newPass)) {
            request.getSession().setAttribute("error", "New password cannot be the same as your old password!");
            return "redirect:/account.changePassword";
        }

        User u = (User) request.getSession().getAttribute("user");

        if (!BCrypt.checkpw(origPass, u.getHash())) {
            request.getSession().setAttribute("error", "Invalid login credentials!");
            return "redirect:/account.changePassword";
        }

        u.setHash(BCrypt.hashpw(newPass, BCrypt.gensalt()));

        userRepo.save(u);

        request.getSession().setAttribute("success", "Password has been changed!");
        return "redirect:/account.changePassword";
    }
}
