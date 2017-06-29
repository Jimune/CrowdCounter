package nl.yc.crowdcounter.crudrepositories;

import nl.yc.crowdcounter.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by jim on 6/26/17.
 */
public interface UserCrudRepo extends CrudRepository<User, Long> {

    Set<User> findAllByNameContaining(String name);
    User findByName(String username);

}
