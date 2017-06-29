package nl.yc.crowdcounter.crudrepositories;

import nl.yc.crowdcounter.model.GraphData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

/**
 * Created by yvo.romp on 29/06/2017.
 */
public interface GraphCrudRepo extends CrudRepository<GraphData, Long> {

    @Query("SELECT gd FROM GraphData gd WHERE gd.location='Borne' AND gd.timestamp BETWEEN '2017-03-29 00:00:01' AND '2017-03-30 00:00:01'")
    Set<String> findByTime();

}
