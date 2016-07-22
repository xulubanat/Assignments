package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.RoomPrice;
import za.ac.cput.hotelReservation.factory.RoomPriceFactory;

/**
 * Created by student on 2016/07/17.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class RoomPriceCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private RoomPriceRepo repository;

    @Test
    public void create() throws Exception
    {
        RoomPrice roomPrice = RoomPriceFactory.createRoomPrice("R800");
        repository.save(roomPrice);
        id = roomPrice.getRoomPriceId();
        Assert.assertNotNull(roomPrice.getRoomPriceId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        RoomPrice roomPrice = repository.findOne(id);
        Assert.assertNotNull(roomPrice.getRoomPriceId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        RoomPrice roomPrice = repository.findOne(id);
        repository.delete(roomPrice);
        RoomPrice deleteRoomPrice = repository.findOne(id);
        Assert.assertNull(deleteRoomPrice);
    }
}
