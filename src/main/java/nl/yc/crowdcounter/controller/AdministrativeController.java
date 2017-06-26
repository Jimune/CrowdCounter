package nl.yc.crowdcounter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jim on 6/26/17.
 */
@Controller
public class AdministrativeController {

    @RequestMapping(value = "/admin/createAccount", method = RequestMethod.GET)
    public String createAccount(HttpServletRequest request) {
        return "createUser";
    }

}
