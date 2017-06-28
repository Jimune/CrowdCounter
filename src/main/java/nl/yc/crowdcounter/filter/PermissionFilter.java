package nl.yc.crowdcounter.filter;

import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.Permission;
import nl.yc.crowdcounter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by jim on 6/26/17.
 */
public class PermissionFilter extends HandlerInterceptorAdapter {

    @Autowired
    UserCrudRepo repo;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HandlerMethod hm = (HandlerMethod) handler;
        Method m = hm.getMethod();
        Accessibility a = m.getDeclaredAnnotation(Accessibility.class);

        if (a != null) {
            if (a.requireLogin()) {
                HttpSession session = request.getSession(false);

                if (session != null && session.getAttribute("user") != null) {
                    if (a.requiredPermissions().length > 0) {
                        User u = (User) session.getAttribute("user");
                        Set<Permission> permissionsObj = u.getPermissions();

                        if (permissionsObj != null && !permissionsObj.isEmpty()) {
                            List<String> permissions = new ArrayList<>();
                            permissionsObj.forEach((perm) -> permissions.add(perm.getPermission()));

                            for (String permission : a.requiredPermissions()) {
                                if (!permissions.contains(permission)) {
                                    response.setStatus(403);

                                    return false;
                                }
                            }

                            return true;
                        } else {
                            response.setStatus(403);

                            return false;
                        }
                    }

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
        }

        return true;
    }

}
