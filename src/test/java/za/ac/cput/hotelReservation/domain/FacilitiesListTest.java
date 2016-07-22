package za.ac.cput.hotelReservation.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.FacilitiesListFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class FacilitiesListTest
{
    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testCreate() throws Exception
    {

        FacilitiesList facilitiesList = FacilitiesListFactory.createFacilitiesList("barFridge");

        Assert.assertEquals("barFridge", facilitiesList.getFacilityDescr());
    }

    @Test
    public void testUpdate() throws Exception
    {
        FacilitiesList facilitiesList = FacilitiesListFactory.createFacilitiesList("barFridge");
        FacilitiesList newFacilitiesList = new FacilitiesList.Builder("barFridge and coffee maker").build();

        Assert.assertEquals("barFridge", facilitiesList.getFacilityDescr());
        Assert.assertEquals("barFridge and coffee maker", newFacilitiesList.getFacilityDescr());
    }
}
