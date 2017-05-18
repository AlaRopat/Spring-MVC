package entities;

import javax.persistence.*;

/**
 * Created by Nikolay Shuvaev on 18.05.2017
 */
@Entity
@Table(name = "scheduleTable")
public class ScheduleItem {
    @EmbeddedId
    private ScheduleItemId id;
    @OneToOne(cascade = CascadeType.ALL)
    private Auditorium auditorium;

    public ScheduleItem() {
    }

    public ScheduleItem(ScheduleItemId id, Auditorium auditorium) {
        this.id = id;
        this.auditorium = auditorium;
    }

    public ScheduleItemId getId() {
        return id;
    }

    public void setId(ScheduleItemId id) {
        this.id = id;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}
