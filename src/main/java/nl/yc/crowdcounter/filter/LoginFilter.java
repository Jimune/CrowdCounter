package nl.yc.crowdcounter.filter;

import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jim on 6/26/17.
 */
public class LoginFilter extends HandlerInterceptorAdapter {

    private String[] requireLogin = {
            "/admin",
            "/account"
    };

    @Autowired
    UserCrudRepo repo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String target = request.getRequestURI();

        if (requireLoginContains(target)) {
            HttpSession session = request.getSession(false);

            if (session != null && session.getAttribute("user") != null) {
                return true;
            } else {
                try {
                    response.sendRedirect("/login");
                } catch (IOException e) {
                    System.out.println("Error redirecting to login page!");
                    e.printStackTrace();
                }

                return false;
            }
        }

        return true;
    }

    private boolean requireLoginContains(String uri) {
        for (String s : requireLogin) {
            if (uri.contains(s)) {
                return true;
            }
        }

        return false;
    }

    private boolean requireLoginContainsExact(String uri) {
        for (String s : requireLogin) {
            if (s.equals(uri)) {
                return true;
            }
        }

        return false;
    }
}
