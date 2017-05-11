package dto;

import entities.Auditorium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by macbook on 02.01.17.
 */
public class AuditoriumDTO {
    private String name;
    private Integer numberOfSeats;
    private Set<Integer> vipSeats;

    public String getName() {
        return name;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public Set<Integer> getVipSeats() {
        return vipSeats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setVipSeats(Set<Integer> vipSeats) {
        this.vipSeats = vipSeats;
    }

    public static AuditoriumDTO of(Auditorium auditorium) {
        AuditoriumDTO dto = new AuditoriumDTO();
        dto.setName(auditorium.getName());
        dto.setNumberOfSeats(auditorium.getNumberOfSeats());
        dto.setVipSeats(getVipSeats(auditorium.getVipSeats()));
        return dto;
    }

    private static Set<Integer> getVipSeats(Set<Integer> vipSeats) {
        Set<Integer> seats = new HashSet<>();
        seats.addAll(vipSeats);
        return seats;
    }
}
