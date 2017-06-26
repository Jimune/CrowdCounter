package nl.yc.crowdcounter.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jim on 23 Jun 17.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public @ResponseBody String test() {
        return "index";
    }
}
