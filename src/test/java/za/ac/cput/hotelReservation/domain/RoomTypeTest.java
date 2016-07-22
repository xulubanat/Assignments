package za.ac.cput.hotelReservation.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.RoomTypeFactory;

/**
 * Created by student on 2016/07/17.
 */
public class RoomTypeTest
{
    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testCreate() throws Exception
    {
        RoomType roomType = RoomTypeFactory.createRoomType("Single");

        Assert.assertEquals("Single", roomType.getRoomType());
    }

    @Test
    public void testUpdate() throws Exception
    {
        RoomType roomType = RoomTypeFactory.createRoomType("Single");
        RoomType newRoomType = new RoomType.Builder("Double").build();

        Assert.assertEquals("Single", roomType.getRoomType());
        Assert.assertEquals("Double", newRoomType.getRoomType());
    }
}
