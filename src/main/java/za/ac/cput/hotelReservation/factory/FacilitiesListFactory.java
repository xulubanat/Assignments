package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.FacilitiesList;

import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class FacilitiesListFactory
{
    public static FacilitiesList createFacilitiesList(String facilityDescr)
    {
        FacilitiesList facilitiesList = new FacilitiesList.Builder(facilityDescr).build();
        return facilitiesList;
    }
}
