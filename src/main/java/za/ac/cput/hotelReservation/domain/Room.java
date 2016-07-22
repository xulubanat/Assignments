package za.ac.cput.hotelReservation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
@Entity
public class Room implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomId;
    private boolean smookingRoom;
    private String roomDescr;
    private int numBeds;
    @ManyToOne(targetEntity = Hotel.class)
    @JoinColumn(name = "hotelName")
    private List<Hotel> hotel = new ArrayList<Hotel>();

    private Room()
    {
    }

    public Long getRoomId() {
        return roomId;
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

    public Room(Builder builder)
    {
        roomId = builder.roomId;
        numBeds = builder.numBeds;
        roomDescr = builder.roomDescr;
        hotel = builder.hotel;
        smookingRoom = builder.smookingRoom;
    }

    public static class Builder
    {
        private Long roomId;
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

        public Builder roomId(Long value)
        {
            this.roomId = value;
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

        public Builder copy(Room value)
        {
            this.roomId = value.getRoomId();
            this.numBeds = value.getNumBeds();
            this.roomDescr = value.getRoomDescr();
            this.hotel = value.getHotel();
            this.smookingRoom = value.isSmookingRoom();
            return this;
        }

        public Room build()
        {
            return new Room(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (numBeds != room.numBeds) return false;
        if (smookingRoom != room.smookingRoom) return false;
        if (hotel != null ? !hotel.equals(room.hotel) : room.hotel != null) return false;
        if (roomDescr != null ? !roomDescr.equals(room.roomDescr) : room.roomDescr != null) return false;
        if (roomId != null ? !roomId.equals(room.roomId) : room.roomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + numBeds;
        result = 31 * result + (smookingRoom ? 1 : 0);
        result = 31 * result + (roomDescr != null ? roomDescr.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", numBeds=" + numBeds +
                ", smookingRoom=" + smookingRoom +
                ", roomDescr='" + roomDescr + '\'' +
                ", hotel=" + hotel +
                '}';
    }
}
