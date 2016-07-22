package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.RoomPrice;

import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class RoomPriceFactory
{
    public static RoomPrice createRoomPrice(String roomPrice)
    {
        RoomPrice roomPrice1 = new RoomPrice.Builder(roomPrice).build();
        return roomPrice1;
    }
}
