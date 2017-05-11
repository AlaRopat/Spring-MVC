package dto;

import entities.Event;
import entities.Rating;

/**
 * Created by Nikolai_Shuvaev on 5/11/2017.
 */
public class EventDTO {
    private long id;
    private String name;
    private double basePrice;
    private Rating rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public static EventDTO of(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setBasePrice(event.getBasePrice());
        eventDTO.setId(event.getId());
        eventDTO.setName(event.getName());
        eventDTO.setRating(event.getRating());
        return eventDTO;
    }
}
