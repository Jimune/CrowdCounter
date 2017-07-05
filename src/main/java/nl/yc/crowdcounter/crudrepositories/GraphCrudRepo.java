package nl.yc.crowdcounter.crudrepositories;

import nl.yc.crowdcounter.model.GraphData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Set;


/**
 * Created by yvo.romp on 29/06/2017.
 */
public interface GraphCrudRepo extends CrudRepository<GraphData, Long> {

    @Query("SELECT gd FROM GraphData gd WHERE gd.location =?3 AND gd.timestamp BETWEEN ?1 AND ?2 AND gd.signalStrength =?4 ORDER BY gd.timestamp ASC ")
    Set<GraphData> findAllByTimeAndLocationAndSignalStrengthOrderByTimestampAsc(Date startDate, Date endDate, String location, String signalStrength);

    @Query("SELECT gd FROM GraphData gd WHERE gd.location =?1 AND gd.timestamp BETWEEN '2017-03-29 00:00:00' AND '2017-03-29 00:01:00' ")
    Set<GraphData> findAllByLocation(String location);

    @Query("SELECT DISTINCT gd.location FROM GraphData gd WHERE gd.location LIKE CONCAT('%', ?1, '%')")
    Set<String> findDistinctByLocationContaining(String location);
}
