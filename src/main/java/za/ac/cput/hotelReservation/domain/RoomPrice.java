package za.ac.cput.hotelReservation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
public class RoomPrice implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomPriceId;
    private String roomPrice;

    private RoomPrice()
    {
    }

    public Long getRoomPriceId() {
        return roomPriceId;
    }

    public void setRoomPriceId(Long roomPriceId) {
        this.roomPriceId = roomPriceId;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public RoomPrice(Builder builder)
    {
        roomPriceId = builder.roomPriceId;
        roomPrice = builder.roomPrice;
    }

    public static class Builder {
        private Long roomPriceId;
        private String roomPrice;

        public Builder(String roomPrice) {
            this.roomPrice = roomPrice;
        }

        public Builder roomPriceId(Long value) {
            this.roomPriceId = value;
            return this;
        }

        public Builder copy(RoomPrice value) {
            this.roomPriceId = value.getRoomPriceId();
            this.roomPrice = value.getRoomPrice();

            return this;
        }

        public RoomPrice build()
        {
            return new RoomPrice(this);
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
