package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.Guest;

import java.util.Map;

/**
 * Created by student on 2015/12/25.
 */
public class GuestFactory
{
    public static Guest createGuest(Map<String, String> title, Map<String, String> names, Map<String, String> contactDet)
    {
        Guest guest = new Guest.Builder(names.get("fName")).lName(names.get("lName")).title(title.get("title")).initials(title.get("initials")).contactNumber(contactDet.get("contactNumber")).emailAddress(contactDet.get("emailAddress")).build();
        return guest;
    }
}
