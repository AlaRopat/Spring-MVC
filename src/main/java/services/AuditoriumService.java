package services;

import entities.Auditorium;
import entities.Event;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by macbook on 02.01.17
 */
public interface AuditoriumService {
    List<Auditorium> getAll();

    Auditorium getByName(String name);

    Auditorium addEvent(Event event, Auditorium auditorium, LocalDateTime dateTime);

    Auditorium getAuditoriumByEventAndDate(Event event, LocalDateTime dateTime);
}
