package za.ac.cput.hotelReservation.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.GuestFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by student on 2015/12/25.
 */
public class GuestTest
{
    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testCreate() throws Exception
    {
        Map<String, String> title = new HashMap<>();
        Map<String, String> names = new HashMap<>();
        Map<String, String> contactDet = new HashMap<>();

        title.put("title", "Miss");
        title.put("initials", "YA");
        names.put("fName", "Yamkela");
        names.put("lName", "Ngaba");
        contactDet.put("contactNumber", "0717723777");
        contactDet.put("emailAddress", "yangaba@yahoo.com");

        Guest guest = GuestFactory.createGuest(title, names, contactDet);

        Assert.assertEquals("YA", guest.getInitials());
    }

    @Test
    public void testUpdate() throws Exception
    {
        Map<String, String> title = new HashMap<>();
        Map<String, String> names = new HashMap<>();
        Map<String, String> contactDet = new HashMap<>();

        title.put("title", "Miss");
        title.put("initials", "YA");
        names.put("fName", "Yamkela");
        names.put("lName", "Ngaba");
        contactDet.put("contactNumber", "0717723777");
        contactDet.put("emailAddress", "yangaba@yahoo.com");

        Guest guest = GuestFactory.createGuest(title, names, contactDet);
        Guest newGuest = new Guest.Builder(guest.getfName()).title("Mr").build();

        Assert.assertEquals("YA", guest.getInitials());
        Assert.assertEquals("Miss", guest.getTitle());
        Assert.assertEquals("Mr", newGuest.getTitle());
    }
}
