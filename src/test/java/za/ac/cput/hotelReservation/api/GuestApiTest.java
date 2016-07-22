package za.ac.cput.hotelReservation.api;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.factory.GuestFactory;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2016/01/03.
 */
public class GuestApiTest
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
    private static void listAllGuests()
    {
        System.out.println("Testing listAllGuests API-----");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> GuestMap = restTemplate.getForObject(REST_SERVICE_URI+"/guests/", List.class);

        if(GuestMap != null)
        {
            for(LinkedHashMap<String, Object> map : GuestMap)
            {
                System.out.println("Guest : id="+map.get("guestId")+", Title ="+map.get("title")+", Initials ="+map.get("initials")+",First Name="+map.get("fName")+",Last Name="+map.get("lName")+",Contact Number ="+map.get("contactNumber")+",Email address ="+map.get("emailAddress"));;

            }
        }
        else
        {
            System.out.println("No Guest exist");
        }
    }

    private static void getGuest()
    {
        System.out.println("Testing getGuest API");
        RestTemplate restTemplate = new RestTemplate();
        Guest Guest = restTemplate.getForObject(REST_SERVICE_URI+"/guests/1", Guest.class);
        System.out.println(Guest);
    }

    private static void createGuest()
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

        System.out.println("Testing create Guest API");
        RestTemplate restTemplate = new RestTemplate();
        Guest Guest = new Guest.Builder(names.get("fName")).title(title.get("title")).initials(title.get("initials")).lName(names.get("lName")).contactNumber(contactDet.get("contactNumber")).emailAddress(contactDet.get("emailAddress")).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/guests/create/", Guest, Guest.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void updateGuest()
    {
        Map<String, String> title = new HashMap<>();
        Map<String, String> names = new HashMap<>();
        Map<String, String> contactDet = new HashMap<>();

        title.put("title", "Mr");
        title.put("initials", "YA");
        names.put("fName", "Yamkela");
        names.put("lName", "Ngaba");
        contactDet.put("contactNumber", "0717723777");
        contactDet.put("emailAddress", "yangaba@yahoo.com");

        System.out.println("Testing update Hotel API");
        RestTemplate restTemplate = new RestTemplate();

        Guest Guest = new Guest.Builder(names.get("fName")).title(title.get("title")).initials(title.get("initials")).lName(names.get("lName")).contactNumber(contactDet.get("contactNumber")).emailAddress(contactDet.get("emailAddress")).build();

        restTemplate.put(REST_SERVICE_URI+"/guests/update/1", Guest);

        System.out.println(Guest);
    }

    private static void deleteGuest()
    {
        System.out.println("Testing delete guest API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/guests/delete/1");
    }

    private static void deleteAllGuests()
    {
        System.out.println("Testing delete guests API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/guests/");
    }
}
