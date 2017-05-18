package entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by macbook on 02.01.17
 */
@Entity
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "num_of_seats")
    private Integer numberOfSeats;
    @ElementCollection(targetClass = Integer.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "vip_seats")
    private Set<Integer> vipSeats;

    public Auditorium() {
    }

    public Auditorium(String name, Integer numberOfSeats, Set<Integer> vipSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.vipSeats = vipSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public Set<Integer> getVipSeats() {
        return vipSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auditorium that = (Auditorium) o;

        if (!name.equals(that.name)) return false;
        if (!numberOfSeats.equals(that.numberOfSeats)) return false;
        return vipSeats.equals(that.vipSeats);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + numberOfSeats.hashCode();
        result = 31 * result + vipSeats.hashCode();
        return result;
    }
}
