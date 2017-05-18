package dao.impl;

import dao.PurchasedTicketDao;
import entities.Event;
import entities.Seat;
import entities.Ticket;
import entities.User;
import org.springframework.stereotype.Repository;
import repositories.TicketRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by NICK on 06.01.2017.
 */
@Repository
public class PurchasedTicketDaoImpl extends BaseDao<TicketRepository> implements PurchasedTicketDao {

    @Override
    public long saveTicket(Ticket ticket) {
        Ticket save = repository.save(ticket);
        return save.getId();
    }

    @Override
    public List<Ticket> getBy(Event event, LocalDateTime dateTime) {
        return repository.findByEventAndDateTime(event, dateTime);
    }

    @Override
    public List<Ticket> getBy(User user) {
        return repository.findByUser(user);
    }

    @Override
    public Set<Seat> getOccupiedSeats(Event event, LocalDateTime dateTime) {
        List<Ticket> tickets = getBy(event, dateTime);
        return tickets == null ? null : tickets.stream().map(Ticket::getSeat).collect(Collectors.toSet());
    }
}
