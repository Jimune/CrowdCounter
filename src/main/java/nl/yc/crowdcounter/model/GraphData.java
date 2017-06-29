package nl.yc.crowdcounter.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yvo.romp on 29/06/2017.
 */
@Entity
public class GraphData {
    private Long id;
    private String address;
    private String location;
    private String signalStrength;
    private Date timestamp;

    public String getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(String signalStrength) {
        this.signalStrength = signalStrength;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
