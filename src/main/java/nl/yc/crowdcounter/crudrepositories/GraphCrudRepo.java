package nl.yc.crowdcounter.crudrepositories;

import nl.yc.crowdcounter.model.GraphData;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yvo.romp on 29/06/2017.
 */
public interface GraphCrudRepo extends CrudRepository<GraphData, Long> {

}
