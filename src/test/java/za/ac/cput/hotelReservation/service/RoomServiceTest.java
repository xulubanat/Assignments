package za.ac.cput.hotelReservation.service;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.domain.Room;
import za.ac.cput.hotelReservation.factory.RoomFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class RoomServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private RoomService service;

    @Test
    public void create() throws Exception
    {
        List<Hotel> hotel = new ArrayList<Hotel>();

        Room room = RoomFactory.createRoom(true, "pent house", 1, null);
        service.save(room);
        id = room.getRoomId();
        Assert.assertNotNull(room);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Room room = service.findById(id);
        Assert.assertEquals(1, room.getNumBeds());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Room room = service.findById(id);
        Room newRoom = new Room.Builder(room.isSmookingRoom()).copy(room).numBeds(2).build();

        service.update(newRoom);
        Room updatedRoom = service.findById(id);
        Assert.assertEquals(2, updatedRoom.getNumBeds());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Room room = service.findById(id);
        service.delete(room);
        Room deleteRoom = service.findById(id);
        Assert.assertNull(deleteRoom);
    }
}
