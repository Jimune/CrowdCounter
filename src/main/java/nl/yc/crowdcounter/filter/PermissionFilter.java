package nl.yc.crowdcounter.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jim on 6/26/17.
 */
public class PermissionFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String target = request.getRequestURI();

        System.out.println(handler);

        return true;
    }

}
