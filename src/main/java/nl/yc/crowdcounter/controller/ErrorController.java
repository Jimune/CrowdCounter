package nl.yc.crowdcounter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jim on 6/27/17.
 */
@Controller
public class ErrorController {

    @RequestMapping("/403")
    public String err403(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("status", "HTTP/1.1 403 Forbidden Access");

        return "403";
    }

}
