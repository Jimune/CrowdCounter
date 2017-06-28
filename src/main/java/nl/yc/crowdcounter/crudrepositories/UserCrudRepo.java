package nl.yc.crowdcounter.crudrepositories;

import nl.yc.crowdcounter.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by jim on 6/26/17.
 */
public interface UserCrudRepo extends CrudRepository<User, Long> {

    @Query("SELECT id,name FROM User WHERE name LIKE %:username%")
    Set<User> findAllLikeName(String username);
    User findByName(String username);

}
