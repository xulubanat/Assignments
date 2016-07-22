package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.domain.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
public class ReservationResource extends ResourceSupport
{
    private Long resId;
    private String arrivalDate;
    private String departDate;
    private boolean smookingRoom;
    private int numOfBed;
    private String highOrLowFloor;
    private List<Hotel> hotel = new ArrayList<Hotel>();
    private List<Guest> guest = new ArrayList<Guest>();

    private ReservationResource()
    {
    }

    public Long getResId() {
        return resId;
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

    public ReservationResource(Builder builder)
    {
        resId = builder.resId;
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
        private Long resId;
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

        public Builder resId(Long value)
        {
            this.resId = value;
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

        public Builder copy(ReservationResource value)
        {
            this.resId = value.getResId();
            this.arrivalDate = value.getArrivalDate();
            this.departDate = value.getDepartDate();
            this.smookingRoom = value.isSmookingRoom();
            this.numOfBed = value.getNumOfBed();
            this.highOrLowFloor = value.getHighOrLowFloor();
            this.hotel = value.getHotel();
            this.guest = value.getGuest();

            return this;
        }

        public ReservationResource build()
        {
            return new ReservationResource(this);
        }
    }

}
