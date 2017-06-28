package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.model.Permission;
import nl.yc.crowdcounter.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jim on 23 Jun 17.
 */
@Controller
public class HomeController {

    @RequestMapping("/index")
    public String test(HttpServletRequest request, Model model) {
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "index";
    }

    @RequestMapping("/json")
    @ResponseBody
    public User dispUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
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


        u.setPermissions(perms);
        request.getSession().setAttribute("user", u);

        return "redirect:/index";
    }

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    @ResponseBody
    public void parse(@RequestBody User user) {
        System.out.println(user);

        System.out.println(user.getName());
        System.out.println(user.getHash());
        user.getPermissions().forEach((i) -> {
            System.out.println(i.getPermission());
            System.out.println(i.getDescription());
        });

    }
}
