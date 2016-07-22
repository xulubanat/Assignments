package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.RoomType;

import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class RoomTypeFactory
{
    private String roomType;
    public static RoomType createRoomType(String roomType)
    {
        RoomType roomType1 = new RoomType.Builder(roomType).build();
        return roomType1;
    }
}
