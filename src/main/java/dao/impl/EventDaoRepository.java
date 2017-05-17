package dao.impl;

import dao.EventDao;
import entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repositories.EventRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolay Shuvaev on 17.05.2017
 */
@Repository
public class EventDaoRepository implements EventDao {

    private EventRepository repository;

    @Override
    public long save(Event event) {
        Event save = repository.save(event);
        return save.getId();
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }

    @Override
    public Event getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public Event getEventByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Event> getAll() {
        Iterable<Event> all = repository.findAll();
        List<Event> result = new ArrayList<>();
        all.forEach(result::add);
        return result;
    }

    @Autowired
    public void setRepository(EventRepository repository) {
        this.repository = repository;
    }
}
