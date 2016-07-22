package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2016/07/17.
 */
public class RoomPriceResource extends ResourceSupport
{
    private Long roomPriceId;
    private String roomPrice;

    private RoomPriceResource()
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

    public RoomPriceResource(Builder builder)
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

        public Builder copy(RoomPriceResource value) {
            this.roomPriceId = value.getRoomPriceId();
            this.roomPrice = value.getRoomPrice();

            return this;
        }

        public RoomPriceResource build()
        {
            return new RoomPriceResource(this);
        }
    }
}
