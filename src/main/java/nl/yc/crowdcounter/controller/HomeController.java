package nl.yc.crowdcounter.controller;

import com.kastkode.springsandwich.filter.annotation.Before;
import com.kastkode.springsandwich.filter.annotation.BeforeElement;
import nl.yc.crowdcounter.prehandler.LoginCheckFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jim on 23 Jun 17.
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    @Before(@BeforeElement(LoginCheckFilter.class))
    public String test() {
        return "index";
    }
}
