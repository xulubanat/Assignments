package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Hotel;
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
        List<Hotel> hotel = new ArrayList<>();

        Room room = RoomFactory.createRoom(true, "pent house", 1, hotel);
        repository.save(room);
        id = room.getRoomId();
        Assert.assertNotNull(room.getRoomId());
    }
}
