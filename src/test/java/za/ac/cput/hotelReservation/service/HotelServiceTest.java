package za.ac.cput.hotelReservation.service;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.factory.HotelFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2016/01/03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class HotelServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private HotelService service;

    @Test
    public void create() throws Exception
    {
        Map<String, String> address = new HashMap<>();
        Map<String, String> contact = new HashMap<>();

        address.put("streetName", "Orange Street");
        address.put("suburb", "Gardens");
        contact.put("phoneNumber", "0214698000");
        contact.put("webAddress", "www.africanpridehotels.com");

        Hotel hotel = HotelFactory.createHotel("African Pride", 15, address, "Cape Town", contact);
        service.save(hotel);
        id = hotel.getId();
        Assert.assertNotNull(hotel);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Hotel hotel = service.findById(id);
        Assert.assertEquals("Orange Street", hotel.getStreetName());

    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Hotel hotel = service.findById(id);
        Map<String, String> newAddress = new HashMap<>();

        newAddress.put("streetName", "Orange Street");
        newAddress.put("suburb", "Cape Town City Centre");

        Hotel newHotel = new Hotel.Builder(hotel.getHotelName()).copy(hotel).streetName(newAddress.get("streetName")).suburb(newAddress.get("suburb")).build();

        service.update(newHotel);
        Hotel updatedHotel = service.findById(id);
        Assert.assertEquals("Cape Town City Centre", updatedHotel.getSuburb());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Hotel hotel = service.findById(id);
        service.delete(hotel);
        Hotel deleteHotel = service.findById(id);
        Assert.assertNull(deleteHotel);
    }
}
