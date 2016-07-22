package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.FacilitiesList;
import za.ac.cput.hotelReservation.domain.RoomFacilities;

import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class RoomFacilitiesFactory
{
    public static RoomFacilities createRoomFacilities(String facilityDetails, List<FacilitiesList> facilitiesListList)
    {
        RoomFacilities roomFacilities = new RoomFacilities.Builder(facilityDetails).facilitiesListList(facilitiesListList).build();
        return roomFacilities;
    }
}
