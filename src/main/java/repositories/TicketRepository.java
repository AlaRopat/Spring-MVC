package repositories;

import entities.Event;
import entities.Ticket;
import entities.User;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Nikolay Shuvaev on 19.05.2017
 */
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByUser(User user);
    List<Ticket> findByEventAndDateTime(Event event, LocalDateTime dataTime);
}
