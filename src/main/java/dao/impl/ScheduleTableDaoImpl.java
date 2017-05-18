package dao.impl;

import dao.ScheduleTableDao;
import entities.Auditorium;
import entities.Event;
import entities.ScheduleItem;
import entities.ScheduleItemId;
import org.springframework.stereotype.Repository;
import repositories.ScheduleTableRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by NICK on 05.01.2017
 */
@Repository
public class ScheduleTableDaoImpl extends BaseDao<ScheduleTableRepository> implements ScheduleTableDao {

    @Override
    public Auditorium addEventToAuditorium(Event event, Auditorium auditorium, LocalDateTime dateTime) {
        ScheduleItemId scheduleItemId = new ScheduleItemId(event.getId(), Timestamp.valueOf(dateTime));
        ScheduleItem scheduleItem = new ScheduleItem(scheduleItemId, auditorium);
        ScheduleItem save = repository.save(scheduleItem);
        return save.getAuditorium();
    }

    @Override
    public Auditorium getAuditoriumByEventAndDate(Event event, LocalDateTime dateTime) {
        ScheduleItemId scheduleItemId = new ScheduleItemId(event.getId(), Timestamp.valueOf(dateTime));
        ScheduleItem item = repository.findOne(scheduleItemId);
        return item != null ? item.getAuditorium() : null;
    }
}
