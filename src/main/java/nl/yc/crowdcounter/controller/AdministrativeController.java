package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jim on 6/26/17.
 */
@Controller
public class AdministrativeController {

    @Autowired
    UserCrudRepo repo;

    @RequestMapping(value = "/admin.createAccount", method = RequestMethod.GET)
    @Accessibility(requireLogin = true, requiredPermissions = {"add_user"})
    public String createAccount(HttpServletRequest request, Model model) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        model.addAttribute("error", request.getSession().getAttribute("error"));
        request.getSession().setAttribute("error", null);

        return "createUser";
    }

    @RequestMapping(value = "/admin.createAccount", method = RequestMethod.POST)
    @Accessibility(requireLogin = true, requiredPermissions = {"add_user"})
    public String createAccountHandle(HttpServletRequest request) {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        String passconf = request.getParameter("passconf");

        if (name == null || name.isEmpty()
                || pass == null || pass.isEmpty()
                || passconf == null || passconf.isEmpty()) {
            
        }

        return "redirect:/admin.createAccount";
    }
}
