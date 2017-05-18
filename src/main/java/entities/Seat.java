package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by macbook on 02.01.17.
 */
@Embeddable
public class Seat {
    @Column(name = "seat_number")
    private int seatNumber;
    @Column(name = "seat_type")
    @Enumerated(EnumType.STRING)
    private SeatType type;

    public Seat() {
    }

    private Seat(int seatNumber, SeatType type) {
        this.seatNumber = seatNumber;
        this.type = type;
    }

    public SeatType getType() {
        return type;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public static Seat of(int seatNumber, SeatType type) {
        return new Seat(seatNumber, type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (seatNumber != seat.seatNumber) return false;
        return type == seat.type;
    }

    @Override
    public int hashCode() {
        int result = seatNumber;
        result = 31 * result + type.hashCode();
        return result;
    }
}
