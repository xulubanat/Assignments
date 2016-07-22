package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hotelReservation.domain.Hotel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
public class RoomResource extends ResourceSupport
{
    private Long resId;
    private boolean smookingRoom;
    private String roomDescr;
    private int numBeds;
    private List<Hotel> hotel = new ArrayList<Hotel>();

    private RoomResource()
    {
    }

    public Long getResId() {
        return resId;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public String getRoomDescr() {
        return roomDescr;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public boolean isSmookingRoom() {
        return smookingRoom;
    }

    public RoomResource(Builder builder)
    {
        resId = builder.resId;
        numBeds = builder.numBeds;
        roomDescr = builder.roomDescr;
        hotel = builder.hotel;
        smookingRoom = builder.smookingRoom;
    }

    public static class Builder
    {
        private Long resId;
        private int numBeds;
        private String roomDescr;
        private List<Hotel> hotel;
        private boolean smookingRoom;

        public Builder(boolean smookingRoom)
        {
            this.smookingRoom = smookingRoom;
        }

        public Builder roomDescr(String value)
        {
            this.roomDescr = value;
            return this;
        }

        public Builder resId(Long value)
        {
            this.resId = value;
            return this;
        }

        public Builder numBeds(int value)
        {
            this.numBeds = value;
            return this;
        }

        public Builder hotel(List<Hotel> value)
        {
            this.hotel = value;
            return this;
        }

        public Builder copy(RoomResource value)
        {
            this.resId = value.getResId();
            this.numBeds = value.getNumBeds();
            this.roomDescr = value.getRoomDescr();
            this.hotel = value.getHotel();
            this.smookingRoom = value.isSmookingRoom();
            return this;
        }

        public RoomResource build()
        {
            return new RoomResource(this);
        }
    }
}
