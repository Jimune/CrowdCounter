package nl.yc.crowdcounter.crudrepositories;

import nl.yc.crowdcounter.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jim on 6/26/17.
 */
public interface UserCrudRepo extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
