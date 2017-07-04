package nl.yc.crowdcounter.model;

import java.util.Set;

/**
 * Created by jim on 7/4/17.
 */
public class ModifyUserPermissionData {

    Set<Long> perms;
    private long uid;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Set<Long> getPerms() {
        return perms;
    }

    public void setPerms(Set<Long> perms) {
        this.perms = perms;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder permss = new StringBuilder();

        perms.forEach((perm) -> permss.append(",").append(perm));

        sb.append("ModifyUserPermissionData:{");
        sb.append("uid:").append(uid).append(",perms:[");
        sb.append(permss.toString().replaceFirst(",", ""));
        sb.append("]}");

        return sb.toString();
    }
}
