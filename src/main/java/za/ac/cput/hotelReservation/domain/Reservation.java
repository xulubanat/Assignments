package za.ac.cput.hotelReservation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/12/25.
 */
@Entity
public class Reservation implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    private String arrivalDate;
    private String departDate;
    private boolean smookingRoom;
    private int numOfBed;
    private String highOrLowFloor;
    @ManyToOne
    @JoinColumn(name = "hotelName")
    private List<Hotel> hotel;
    @ManyToOne
    @JoinColumn(name = "guestId")
    private List<Guest> guest;

    private Reservation()
    {
    }

    public Long getReservationId() {
        return reservationId;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getDepartDate() {
        return departDate;
    }

    public boolean isSmookingRoom() {
        return smookingRoom;
    }

    public int getNumOfBed() {
        return numOfBed;
    }

    public String getHighOrLowFloor() {
        return highOrLowFloor;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public List<Guest> getGuest() {
        return guest;
    }

    public Reservation(Builder builder)
    {
        reservationId = builder.reservationId;
        arrivalDate = builder.arrivalDate;
        departDate = builder.departDate;
        smookingRoom = builder.smookingRoom;
        numOfBed = builder.numOfBed;
        highOrLowFloor = builder.highOrLowFloor;
        hotel = builder.hotel;
        guest = builder.guest;
    }

    public static class Builder
    {
        private Long reservationId;
        private String arrivalDate;
        private String departDate;
        private boolean smookingRoom;
        private int numOfBed;
        private String highOrLowFloor;
        private List<Hotel> hotel;
        private List<Guest> guest;

        public Builder(String arrivalDate)
        {
            this.arrivalDate = arrivalDate;
        }

        public Builder reservationId(Long value)
        {
            this.reservationId = value;
            return this;
        }

        public Builder departDate(String value)
        {
            this.departDate = value;
            return this;
        }

        public Builder smookingRoom(boolean value)
        {
            this.smookingRoom = value;
            return this;
        }

        public Builder numOfBed(int value)
        {
            this.numOfBed = value;
            return this;
        }

        public Builder highOrLowFloor(String value)
        {
            this.highOrLowFloor = value;
            return this;
        }

        public Builder hotel(List<Hotel> value)
        {
            this.hotel = value;
            return this;
        }

        public Builder guest(List<Guest> value)
        {
            this.guest = value;
            return this;
        }

        public Builder copy(Reservation value)
        {
            this.reservationId = value.getReservationId();
            this.arrivalDate = value.getArrivalDate();
            this.departDate = value.getDepartDate();
            this.smookingRoom = value.isSmookingRoom();
            this.numOfBed = value.getNumOfBed();
            this.highOrLowFloor = value.getHighOrLowFloor();
            this.hotel = value.getHotel();
            this.guest = value.getGuest();

            return this;
        }

        public Reservation build()
        {
            return new Reservation(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reservation that = (Reservation) o;

        if (numOfBed != that.numOfBed) return false;
        if (smookingRoom != that.smookingRoom) return false;
        if (arrivalDate != null ? !arrivalDate.equals(that.arrivalDate) : that.arrivalDate != null) return false;
        if (departDate != null ? !departDate.equals(that.departDate) : that.departDate != null) return false;
        if (guest != null ? !guest.equals(that.guest) : that.guest != null) return false;
        if (highOrLowFloor != null ? !highOrLowFloor.equals(that.highOrLowFloor) : that.highOrLowFloor != null)
            return false;
        if (hotel != null ? !hotel.equals(that.hotel) : that.hotel != null) return false;
        if (reservationId != null ? !reservationId.equals(that.reservationId) : that.reservationId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = reservationId != null ? reservationId.hashCode() : 0;
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + (departDate != null ? departDate.hashCode() : 0);
        result = 31 * result + (smookingRoom ? 1 : 0);
        result = 31 * result + numOfBed;
        result = 31 * result + (highOrLowFloor != null ? highOrLowFloor.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        result = 31 * result + (guest != null ? guest.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departDate='" + departDate + '\'' +
                ", smookingRoom=" + smookingRoom +
                ", numOfBed=" + numOfBed +
                ", highOrLowFloor='" + highOrLowFloor + '\'' +
                ", hotel=" + hotel +
                ", guest=" + guest +
                '}';
    }
}
