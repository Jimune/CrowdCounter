package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.SessionCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.LoginSession;
import nl.yc.crowdcounter.model.User;
import nl.yc.crowdcounter.util.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.Set;

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
    public String loginView(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            return "redirect:/index";
        }

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginHandle(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (name == null || name.isEmpty()
                || pass == null || pass.isEmpty()) {
            request.getSession().setAttribute("error", "Username and password do not match!");
            return "redirect:/index";
        }

        User u = userRepo.findByName(name);

        if (u == null) {
            request.getSession().setAttribute("error", "Username and password do not match!");
            return "redirect:/login";
        }

        if (BCrypt.checkpw(pass, u.getHash())) {

            Set<LoginSession> sessions = u.getSessions();
            LoginSession s = new LoginSession();
            s.setLogin(new Date(System.currentTimeMillis()));

            s.setIp(request.getRemoteAddr());
            sessRepo.save(s);

            request.getSession().setAttribute("user", u);

            sessions.add(s);
            u.setSessions(sessions);

            userRepo.save(u);

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
