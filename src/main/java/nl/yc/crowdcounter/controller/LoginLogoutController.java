package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.SessionCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.LoginSession;
import nl.yc.crowdcounter.model.User;
import nl.yc.crowdcounter.util.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by jim on 6/26/17.
 */
@Controller
public class LoginLogoutController {

    @Autowired
    UserCrudRepo userRepo;
    @Autowired
    SessionCrudRepo sessRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            return "redirect:/index";
        }

        session = request.getSession();
        model.addAttribute("error", session.getAttribute("error"));
        session.setAttribute("error", null);

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginHandle(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (name == null || name.isEmpty()
                || pass == null || pass.isEmpty()) {
            request.getSession().setAttribute("error", "Username and password do not match!");
            return "redirect:/login";
        }

        User u = userRepo.findByName(name);

        if (u == null) {
            request.getSession().setAttribute("error", "Username and password do not match!");
            return "redirect:/login";
        }

        if (BCrypt.checkpw(pass, u.getHash())) {
            LoginSession session = new LoginSession();
            session.setIp(request.getRemoteAddr());

            request.getSession().setAttribute("user", u);
            request.getSession().setAttribute("error", null);
            return "redirect:/index";
        }

        request.getSession().setAttribute("error", "Username and password do not match!");
        return "redirect:/login";
    }

    @RequestMapping("/logout")
    @Accessibility(requireLogin = true)
    public String logoutHandle(HttpServletRequest request) {
        request.getSession().invalidate();

        return "redirect:/index";
    }

}
