package nl.yc.crowdcounter.model;

import nl.yc.crowdcounter.util.Util;

import javax.persistence.*;

/**
 * Created by jim on 6/26/17.
 */
@Entity
public class Permission {

    private Long id;
    private String permission;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return Util.build("Permission:{id:", id, ",permission:", permission, ",description:", description, "}");
    }
}
