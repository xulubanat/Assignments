package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.FacilitiesList;
import za.ac.cput.hotelReservation.factory.FacilitiesListFactory;

/**
 * Created by student on 2016/07/17.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class FacilitiesListCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private FacilitiesListRepo repository;

    @Test
    public void create() throws Exception
    {
        FacilitiesList facilitiesList = FacilitiesListFactory.createFacilitiesList("barFridge");
        repository.save(facilitiesList);
        id = facilitiesList.getFacilitiesId();
        Assert.assertNotNull(facilitiesList.getFacilitiesId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        FacilitiesList facilitiesList = repository.findOne(id);
        Assert.assertNotNull(facilitiesList.getFacilitiesId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        FacilitiesList facilitiesList = repository.findOne(id);
        repository.delete(facilitiesList);
        FacilitiesList deleteFacilitiesList = repository.findOne(id);
        Assert.assertNull(deleteFacilitiesList);
    }
}
