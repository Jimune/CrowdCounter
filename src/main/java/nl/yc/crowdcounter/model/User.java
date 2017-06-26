package nl.yc.crowdcounter.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jim on 6/26/17.
 */
@Entity
public class User {

    private Long id;
    private String name;
    private String hash;
    private List<Permission> permissions;
    private List<LoginSession> sessions;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "username", unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "passhash", nullable = false)
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @OneToMany
    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    @OrderBy("login DESC")
    @OneToMany
    public List<LoginSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<LoginSession> sessions) {
        this.sessions = sessions;
    }
}
