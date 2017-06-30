package nl.yc.crowdcounter.filter;

import nl.yc.crowdcounter.crudrepositories.SessionCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.LoginSession;
import nl.yc.crowdcounter.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.sql.Date;

/**
 * Created by Jim on 30-6-2017.
 */
public class CrowdCounterSessionListener implements HttpSessionListener {

    @Autowired
    UserCrudRepo userRepo;
    @Autowired
    SessionCrudRepo sessRepo;

    @Override
    public void sessionCreated(HttpSessionEvent e) {
        e.getSession().setMaxInactiveInterval(30 * 60); // 30 minutes
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent e) {
        User u = (User) e.getSession().getAttribute("user");
        Long id = u.getId();
        LoginSession loginSession = userRepo.findOne(id).getSessions().iterator().next();

        loginSession.setLogout(new Date(System.currentTimeMillis()));
        sessRepo.save(loginSession);
        userRepo.save(u);
    }
}
