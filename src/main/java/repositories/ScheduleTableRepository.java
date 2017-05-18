package repositories;

import entities.ScheduleItem;
import entities.ScheduleItemId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nikolay Shuvaev on 18.05.2017
 */
public interface ScheduleTableRepository extends CrudRepository<ScheduleItem, ScheduleItemId> {
}
