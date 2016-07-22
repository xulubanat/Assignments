package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2016/07/17.
 */
public class RoomTypeResource extends ResourceSupport
{
    private Long roomTypeId;
    private String roomType;

    private RoomTypeResource()
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

    public RoomTypeResource(Builder builder)
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

        public Builder copy(RoomTypeResource value) {
            this.roomTypeId = value.getRoomTypeId();
            this.roomType = value.getRoomType();

            return this;
        }

        public RoomTypeResource build()
        {
            return new RoomTypeResource(this);
        }
    }
}
