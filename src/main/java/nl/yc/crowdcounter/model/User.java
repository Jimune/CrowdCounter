package nl.yc.crowdcounter.model;

import nl.yc.crowdcounter.util.Util;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by jim on 6/26/17.
 */
@Entity
public class User {

    private Long id;
    private String name;
    private String hash;
    private Set<Permission> permissions;
    private Set<LoginSession> sessions;

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

    @OrderBy("id ASC")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_permissions",
            joinColumns = {@JoinColumn(name = "User_id")},
            inverseJoinColumns = {@JoinColumn(name = "Permission_id")})
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @OrderBy("login DESC")
    @OneToMany(fetch = FetchType.EAGER)
    public Set<LoginSession> getSessions() {
        return sessions;
    }

    public void setSessions(Set<LoginSession> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        StringBuilder permBuilder = new StringBuilder();
        if (permissions != null) permissions.forEach((perm) -> permBuilder.append(",").append(perm));
        StringBuilder sessBuilder = new StringBuilder();
        if (sessions != null) sessions.forEach((sess) -> sessBuilder.append(",").append(sess));

        return Util.build("User:{id:", id, ",name:", name, ",hash:", hash,
                ",permissions:[", permBuilder.toString().replaceFirst(",", ""),
                "],sessions:[", sessBuilder.toString().replaceFirst(",", ""), "]}");
    }
}
