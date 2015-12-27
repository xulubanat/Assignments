package za.ac.cput.hotelReservation.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.HotelFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/12/25.
 */
public class HotelTest
{
    private String hotelName;
    private int streetNum;
    private String streetName;
    private String suburb;
    private String city;
    private int phoneNumber;
    private String webAddress;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreate() throws Exception
    {
        Map<String, String> address = new HashMap<>();
        Map<String, String> contact = new HashMap<>();

        address.put("streetName", "Orange Street");
        address.put("suburb", "Gardens");
        contact.put("phoneNumber", "0214698000");
        contact.put("webAddress", "www.africanpridehotels.com");

        Hotel hotel = HotelFactory.createHotel("African Pride", 15, address, "Cape Town",contact);

        Assert.assertEquals("Orange Street", hotel.getStreetName());
    }

    @Test
    public void testUpdate() throws Exception
    {
        Map<String, String> address = new HashMap<>();
        Map<String, String> contact = new HashMap<>();
        Map<String, String> newAddress = new HashMap<>();

        address.put("streetName", "Orange Street");
        address.put("suburb", "Gardens");
        contact.put("phoneNumber", "0214698000");
        contact.put("webAddress", "www.africanpridehotels.com");

        newAddress.put("streetName", "Orange Street");
        newAddress.put("suburb", "Cape Town City Centre");

        Hotel hotel = HotelFactory.createHotel("African Pride", 15, address, "Cape Town",contact);
        Hotel newHotel = new Hotel.Builder(hotel.getHotelName()).streetName(newAddress.get("streetName")).suburb(newAddress.get("suburb")).build();

        Assert.assertEquals("Orange Street", hotel.getStreetName());
        Assert.assertEquals("Gardens", hotel.getSuburb());
        Assert.assertEquals("Cape Town City Centre", newHotel.getSuburb());
    }

}
