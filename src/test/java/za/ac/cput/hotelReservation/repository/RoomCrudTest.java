package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.domain.Reservation;
import za.ac.cput.hotelReservation.domain.Room;
import za.ac.cput.hotelReservation.factory.RoomFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/12/27.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class RoomCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private RoomRepo repository;

    @Test
    public void create() throws Exception
    {
        List<Hotel> hotel = new ArrayList<Hotel>();

        Room room = RoomFactory.createRoom(true, "pent house", 1, null);
        repository.save(room);
        id = room.getRoomId();
        Assert.assertNotNull(room.getRoomId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Room room = repository.findOne(id);
        Assert.assertNotNull(room.getRoomId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Room room = repository.findOne(id);
        repository.delete(room);
        Room deleteRoom = repository.findOne(id);
        Assert.assertNull(deleteRoom);
    }
}

