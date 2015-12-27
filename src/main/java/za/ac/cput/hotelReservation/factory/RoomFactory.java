package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.domain.Room;

import java.util.List;

/**
 * Created by student on 2015/12/25.
 */
public class RoomFactory
{
    private boolean smookingRoom;
    private String roomDescr;
    private int numBeds;
    private List<Hotel> hotel;

    public static Room createRoom(boolean smookingRoom, String roomDescr, int numBeds, List<Hotel> hotel)
    {
        Room room = new Room.Builder(smookingRoom).roomDescr(roomDescr).numBeds(numBeds).hotel(hotel).build();
        return room;
    }
}
