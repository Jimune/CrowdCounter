package nl.yc.crowdcounter.model;

import nl.yc.crowdcounter.util.Util;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by jim on 6/26/17.
 */
@Entity
public class LoginSession {

    private Long id;
    private String ip;
    private Date login;
    private Date logout;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLogin() {
        return login;
    }

    public void setLogin(Date login) {
        this.login = login;
    }

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLogout() {
        return logout;
    }

    public void setLogout(Date logout) {
        this.logout = logout;
    }

    @Override
    public String toString() {
        return Util.build("LoginSession:{id:", id, ",ip:", ip, ",login:", login, "logout:", logout,"}");
    }
}
