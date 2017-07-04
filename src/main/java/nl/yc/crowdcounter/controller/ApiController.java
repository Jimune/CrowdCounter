package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.PermissionCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.Permission;
import nl.yc.crowdcounter.model.User;
import nl.yc.crowdcounter.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jim on 7/4/17.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    PermissionCrudRepo permCrudRepo;
    @Autowired
    UserCrudRepo userRepo;

    @RequestMapping(value = "/permissions")
    @ResponseBody
    @Accessibility(requireLogin = true, requiredPermissions = {"modify_user"})
    public Iterable<Permission> getAllPermissions() {
        return permCrudRepo.findAll();
    }

    @RequestMapping(value = "/userPermissions/{id}")
    @ResponseBody
    @Accessibility(requireLogin = true, requiredPermissions = {"modify_user"})
    public Object getUserPermissions(@PathVariable String id) {
        if (id == null || id.isEmpty())
            return Util.build("{\"error\":\"Request id cannot be null\",\"requestVal\":\"", id, "\"}");

        long uid = 0;

        try {
            uid = Long.parseLong(id);
        } catch (NumberFormatException nfe) {
            return Util.build("{\"error\":\"Id was not a number\",\"requestVal\":\"", id, "\"}");
        }

        User u = userRepo.findOne(uid);

        if (u == null)
            return Util.build("{\"error\":\"User with such id does not exist\",\"requestVal\":\"", id, "\"}");

        Set<Long> ints = new HashSet<>();

        for (Permission p : u.getPermissions()) {
            ints.add(p.getId());
        }

        return ints;
    }
}
