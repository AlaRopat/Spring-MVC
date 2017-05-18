package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by macbook on 02.01.17
 */
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne()
    private User user;
    @OneToOne
    private Event event;
    @Column(name = "date_time")
    private LocalDateTime dateTime;
    @Embedded
    private Seat seat;

    public Ticket() {
    }

    private Ticket(Event event, LocalDateTime dateTime, Seat seat) {
        this.event = event;
        this.dateTime = dateTime;
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Event getEvent() {
        return event;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public static Ticket of(Event event, LocalDateTime dateTime, Seat seat) {
        return new Ticket(event, dateTime, seat);
    }

    public Ticket add(User user) {
        this.setUser(user);
        return this;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
