package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.RoomType;
import za.ac.cput.hotelReservation.factory.RoomTypeFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class RoomTypeCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private RoomTypeRepo repository;

    @Test
    public void create() throws Exception
    {
        RoomType roomType = RoomTypeFactory.createRoomType("Single");
        repository.save(roomType);
        id = roomType.getRoomTypeId();
        Assert.assertNotNull(roomType.getRoomTypeId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        RoomType roomType = repository.findOne(id);
        Assert.assertNotNull(roomType.getRoomTypeId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        RoomType roomType = repository.findOne(id);
        repository.delete(roomType);
        RoomType deleteRoomType = repository.findOne(id);
        Assert.assertNull(deleteRoomType);
    }
}
