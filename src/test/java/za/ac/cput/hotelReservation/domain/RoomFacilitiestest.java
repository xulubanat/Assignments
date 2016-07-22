package za.ac.cput.hotelReservation.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.RoomFacilitiesFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class RoomFacilitiestest
{
    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testCreate() throws Exception
    {
        List<FacilitiesList> facilitiesLists = new ArrayList<>();


        RoomFacilities roomFacilities = RoomFacilitiesFactory.createRoomFacilities("barFridge for cold beverages", facilitiesLists);

        Assert.assertEquals("barFridge for cold beverages", roomFacilities.getFacilityDetails());
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<FacilitiesList> facilitiesLists = new ArrayList<>();


        RoomFacilities roomFacilities = RoomFacilitiesFactory.createRoomFacilities("barFridge for cold beverages", facilitiesLists);
        FacilitiesList newFacilitiesList = new FacilitiesList.Builder("barFridge and coffee maker").build();

        Assert.assertEquals("barFridge for cold beverages", roomFacilities.getFacilityDetails());
        Assert.assertEquals("barFridge and coffee maker", newFacilitiesList.getFacilityDescr());
    }
}
