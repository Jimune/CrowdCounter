package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.Permission;
import nl.yc.crowdcounter.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jim on 23 Jun 17.
 */
@Controller
public class HomeController {

    @RequestMapping("/index")
    public String home(HttpServletRequest request, Model model) {
        return "index";
    }

    @RequestMapping("/")
    public String sendToIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/presentation")
    @Accessibility
    public String loadPresentation() {
        return "presentation";
    }

    @RequestMapping("/fake")
    public String createSession(HttpServletRequest request) {
        User u = new User();
        u.setName("Test");
        u.setHash("f928nf2iif298ejklsdlcnoisnefn0392i3dim");

        Set<Permission> perms = new HashSet<Permission>();
        Permission p1 = new Permission();
        p1.setDescription("Access to create a new user");
        p1.setPermission("add_user");
        perms.add(p1);
        Permission p2 = new Permission();
        p2.setDescription("Access to admin commands");
        p2.setPermission("can_admin");
        perms.add(p2);
        Permission p3 = new Permission();
        p3.setDescription("Access to modify users");
        p3.setPermission("modify_user");
        perms.add(p3);
        Permission p4 = new Permission();
        p4.setDescription("Access to create permissions");
        p4.setPermission("create_perm");
        perms.add(p4);
        Permission p5 = new Permission();
        p5.setDescription("Access to create permissions");
        p5.setPermission("change_pass");
        perms.add(p5);

        u.setPermissions(perms);
        request.getSession().setAttribute("user", u);

        return "redirect:/index";
    }
}
