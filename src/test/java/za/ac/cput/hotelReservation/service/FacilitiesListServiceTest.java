package za.ac.cput.hotelReservation.service;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.FacilitiesList;
import za.ac.cput.hotelReservation.factory.FacilitiesListFactory;
import za.ac.cput.hotelReservation.repository.FacilitiesListRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class FacilitiesListServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private FacilitiesListService service;

    @Test
    public void create() throws Exception
    {
        FacilitiesList facilitiesList = FacilitiesListFactory.createFacilitiesList("barFridge");
        service.save(facilitiesList);
        id = facilitiesList.getFacilitiesId();
        Assert.assertNotNull(facilitiesList);

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        FacilitiesList facilitiesList = service.findById(id);
        Assert.assertEquals("barFridge", facilitiesList.getFacilityDescr());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        FacilitiesList facilitiesList = service.findById(id);
        FacilitiesList newFacilitiesList = new FacilitiesList.Builder("barFridge and coffee maker").build();
        service.update(newFacilitiesList);
        FacilitiesList updateFacilitiesList = service.findById(id);

        Assert.assertEquals("barFridge and coffee maker", updateFacilitiesList.getFacilityDescr());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        FacilitiesList facilitiesList = service.findById(id);
        service.delete(facilitiesList);
        FacilitiesList deleteFacilitiesList = service.findById(id);
        Assert.assertNull(deleteFacilitiesList);
    }
 }
