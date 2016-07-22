package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.factory.HotelFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/12/27.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class HotelCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private HotelRepo repository;

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
        repository.save(hotel);
        id = hotel.getId();
        Assert.assertNotNull(hotel.getHotelName());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Hotel hotel = repository.findOne(id);
        Assert.assertNotNull(hotel.getHotelName());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Hotel hotel = repository.findOne(id);
        repository.delete(hotel);
        Hotel deleteHotel = repository.findOne(id);
        Assert.assertNull(deleteHotel);
    }
}
