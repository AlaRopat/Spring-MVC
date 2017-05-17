package entities;

import javax.persistence.*;

/**
 * Created by macbook on 02.01.17
 */
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "base_price")
    private double basePrice;
    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    public Event() {

    }
    public Event(String name, double basePrice, Rating rating) {
        this.name = name;
        this.basePrice = basePrice;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public Rating getRating() {
        return rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
