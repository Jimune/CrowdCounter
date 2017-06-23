package nl.yc.crowdcounter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jim on 23 Jun 17.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String test() {
        return "index";
    }
}
