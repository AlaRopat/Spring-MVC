package entities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Nikolay Shuvaev on 18.05.2017
 */
@Embeddable
public class ScheduleItemId implements Serializable {
    private long event_id;
    private Timestamp date_time;

    public ScheduleItemId() {
    }

    public ScheduleItemId(long event_id, Timestamp date_time) {
        this.event_id = event_id;
        this.date_time = date_time;
    }

    public long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }
}
