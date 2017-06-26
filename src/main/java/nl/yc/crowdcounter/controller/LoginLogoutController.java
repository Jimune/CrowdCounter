package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by jim on 6/26/17.
 */
@Controller
public class LoginLogoutController {

    @Autowired
    UserCrudRepo userrepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginHandle(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            return "redirect:/index";
        }

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginHandle(HttpServletRequest request,
                              @RequestParam("username") String user,
                              @RequestParam("password") String pass) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            pass = null;
            user = null;

            return "redirect:/index";
        }

        User u = userrepo.findByName(user);

        if (u == null) {
            request.setAttribute("error", "Username and password do not match!");
            return "redirect:/login";
        }

        request.getSession().invalidate();
        request.getSession();

        return "redirect:/index";
    }


}
