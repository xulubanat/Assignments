package za.ac.cput.hotelReservation.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.RoomPriceFactory;

/**
 * Created by student on 2016/07/17.
 */
public class RoomPriceTest
{
    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testCreate() throws Exception
    {
        RoomPrice roomPrice = RoomPriceFactory.createRoomPrice("R800");

        Assert.assertEquals("R800", roomPrice.getRoomPrice());
    }

    @Test
    public void testUpdate() throws Exception
    {
        RoomPrice roomPrice = RoomPriceFactory.createRoomPrice("R800");
        RoomPrice newRoomPrice = new RoomPrice.Builder("R900").build();

        Assert.assertEquals("R800", roomPrice.getRoomPrice());
        Assert.assertEquals("R900", newRoomPrice.getRoomPrice());
    }
}
