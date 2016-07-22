package za.ac.cput.hotelReservation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
public class RoomType implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomTypeId;
    private String roomType;

    private RoomType()
    {
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public RoomType(Builder builder)
    {
        roomTypeId = builder.roomTypeId;
        roomType = builder.roomType;
    }

    public static class Builder {
        private Long roomTypeId;
        private String roomType;

        public Builder(String roomType) {
            this.roomType = roomType;
        }

        public Builder roomTypeId(Long value) {
            this.roomTypeId = value;
            return this;
        }

        public Builder copy(RoomType value) {
            this.roomTypeId = value.getRoomTypeId();
            this.roomType = value.getRoomType();

            return this;
        }

        public RoomType build()
        {
            return new RoomType(this);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
