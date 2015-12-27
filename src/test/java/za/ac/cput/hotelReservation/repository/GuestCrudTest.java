package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.factory.GuestFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/12/27.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class GuestCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private GuestRepo repository;

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
        repository.save(guest);
        id = guest.getGuestId();
        Assert.assertNotNull(guest.getGuestId());

    }
}
