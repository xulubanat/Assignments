package za.ac.cput.hotelReservation.api;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.factory.HotelFactory;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2016/01/03.
 */
public class HotelApiTest
{
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    @BeforeMethod
    public void setUp() throws Exception
    {
        template = new TestRestTemplate();
    }

    @Test
    public void testRead() throws Exception
    {

    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";
    @SuppressWarnings("unchecked")
    private static void listAllHotels()
    {
        System.out.println("Testing listAllHotels API-----");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> HotelMap = restTemplate.getForObject(REST_SERVICE_URI+"/hotels/", List.class);

        if(HotelMap != null)
        {
            for(LinkedHashMap<String, Object> map : HotelMap)
            {
                System.out.println("Hotel : id="+map.get("id")+", Hotel Name="+map.get("hotelName")+", Street Number="+map.get("streetNum")+",Street Name="+map.get("streetName")+",Suburb="+map.get("suburb")+",City="+map.get("city")+",Contact Number="+map.get("phoneNumber")+", Web Address="+map.get("webAddress"));;

            }
        }
        else
        {
            System.out.println("No Hotel exist");
        }
    }

    private static void getHotel()
    {
        System.out.println("Testing getHotel API");
        RestTemplate restTemplate = new RestTemplate();
        Hotel Hotel = restTemplate.getForObject(REST_SERVICE_URI+"/hotels/1", Hotel.class);
        System.out.println(Hotel);
    }

    private static void createHotel()
    {
        Map<String, String> contact = new HashMap<>();
        Map<String, String> newAddress = new HashMap<>();

        contact.put("phoneNumber", "0214698000");
        contact.put("webAddress", "www.africanpridehotels.com");

        newAddress.put("streetName", "Orange Street");
        newAddress.put("suburb", "Cape Town City Centre");

        System.out.println("Testing create Hotel API");
        RestTemplate restTemplate = new RestTemplate();
        Hotel Hotel = new Hotel.Builder("African Pride").streetNum(15).streetName(newAddress.get("streetName")).suburb(newAddress.get("suburb")).city("Cape Town").phoneNumber(contact.get("phoneNumber")).webAddress(contact.get("webAddress")).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/hotel/create/", Hotel, Hotel.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void updateHotel()
    {
        Map<String, String> contact = new HashMap<>();
        Map<String, String> newAddress = new HashMap<>();

        contact.put("phoneNumber", "0214698000");
        contact.put("webAddress", "www.africanpridehotels.com");

        newAddress.put("streetName", "Orange Street");
        newAddress.put("suburb", "Cape Town City Centre");

        System.out.println("Testing update Hotel API");
        RestTemplate restTemplate = new RestTemplate();
        Hotel Hotel = new Hotel.Builder("African Pride").streetNum(16).streetName(newAddress.get("streetName")).suburb(newAddress.get("suburb")).city("Cape Town").phoneNumber(contact.get("phoneNumber")).webAddress(contact.get("webAddress")).build();
        restTemplate.put(REST_SERVICE_URI+"/hotels/update/1", Hotel);

        System.out.println(Hotel);
    }

    private static void deleteHotel()
    {
        System.out.println("Testing delete hotel API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/hotels/delete/1");
    }

    private static void deleteAllHotels()
    {
        System.out.println("Testing delete hotels API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/hotels/");
    }
}
