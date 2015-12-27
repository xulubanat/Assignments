package za.ac.cput.hotelReservation.domain;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.RoomFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/12/25.
 */
public class RoomTest
{
    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testCreate() throws Exception
    {
        List<Hotel> hotel = new ArrayList<>();

        Room room = RoomFactory.createRoom(true, "pent house", 1, hotel);

        Assert.assertEquals(1, room.getNumBeds());
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<Hotel> hotel = new ArrayList<>();

        Room room = RoomFactory.createRoom(true, "pent house", 1, hotel);
        Room newRoom = new Room.Builder(room.isSmookingRoom()).numBeds(2).build();

        Assert.assertEquals(1, room.getNumBeds());
        Assert.assertEquals(2, newRoom.getNumBeds());
    }
}
