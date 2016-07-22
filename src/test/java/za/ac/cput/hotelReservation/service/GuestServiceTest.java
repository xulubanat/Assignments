package za.ac.cput.hotelReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.factory.GuestFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2016/01/03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class GuestServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private GuestService service;

    @Test
    public void create() throws Exception
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
        service.save(guest);
        id = guest.getGuestId();
        Assert.assertNotNull(guest);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Guest guest = service.findById(id);
        Assert.assertEquals("YA", guest.getInitials());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Guest guest = service.findById(id);
        Guest newGuest = new Guest.Builder(guest.getfName()).copy(guest).title("Mr").build();
        service.update(newGuest);
        Guest updateGuest = service.findById(id);
        Assert.assertEquals("Mr", updateGuest.getTitle());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Guest guest = service.findById(id);
        service.delete(guest);
        Guest deletedGuest = service.findById(id);
        Assert.assertNull(deletedGuest);
    }
}
