package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.FacilitiesList;
import za.ac.cput.hotelReservation.domain.RoomFacilities;
import za.ac.cput.hotelReservation.factory.RoomFacilitiesFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class RoomFacilitiesCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private RoomFacilitiesRepo repository;

    @Test
    public void create() throws Exception
    {
        List<FacilitiesList> facilitiesLists = new ArrayList<>();


        RoomFacilities roomFacilities = RoomFacilitiesFactory.createRoomFacilities("barFridge for cold beverages", facilitiesLists);

        repository.save(roomFacilities);
        id = roomFacilities.getRoomFacilityId();
        Assert.assertNotNull(roomFacilities.getRoomFacilityId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        RoomFacilities roomFacilities = repository.findOne(id);
        Assert.assertNotNull(roomFacilities.getRoomFacilityId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        RoomFacilities roomFacilities = repository.findOne(id);
        repository.delete(roomFacilities);
        RoomFacilities deleteRoomFacilities = repository.findOne(id);
        Assert.assertNull(deleteRoomFacilities);
    }
}
