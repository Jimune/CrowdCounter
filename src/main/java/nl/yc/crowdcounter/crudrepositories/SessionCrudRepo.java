package nl.yc.crowdcounter.crudrepositories;

import nl.yc.crowdcounter.model.LoginSession;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jim on 6/27/17.
 */
public interface SessionCrudRepo extends CrudRepository<LoginSession, Long> {
}
