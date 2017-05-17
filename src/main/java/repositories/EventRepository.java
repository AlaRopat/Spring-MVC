package repositories;

import entities.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nikolay Shuvaev on 17.05.2017
 */
public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByName(String name);
}
