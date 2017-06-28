package nl.yc.crowdcounter.crudrepositories;

import nl.yc.crowdcounter.model.Permission;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jim on 6/27/17.
 */
public interface PermissionCrudRepo extends CrudRepository<Permission, Long> {
}
