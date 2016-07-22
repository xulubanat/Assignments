package za.ac.cput.hotelReservation.api;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.domain.Room;
import za.ac.cput.hotelReservation.factory.RoomFactory;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
public class RoomApiTest
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
    private static void listAllRooms()
    {
        System.out.println("Testing listAllRooms API-----");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> RoomMap = restTemplate.getForObject(REST_SERVICE_URI+"/rooms/", List.class);

        if(RoomMap != null)
        {
            for(LinkedHashMap<String, Object> map : RoomMap)
            {
              System.out.println("Room : id="+map.get("roomId")+", Smooking Room="+map.get("smookingRoom")+", Room Description ="+map.get("roomDescr")+",Number of Beds="+map.get("numBeds")+",Hotel ="+map.get("hotel"));;
            }
        }
        else
        {
            System.out.println("No Room exist");
        }
    }

    private static void getRoom()
    {
        System.out.println("Testing getRoom API");
        RestTemplate restTemplate = new RestTemplate();
        Room Room = restTemplate.getForObject(REST_SERVICE_URI+"/rooms/1", Room.class);
        System.out.println(Room);
    }

    private static void createRoom()
    {
        List<Hotel> hotel = new ArrayList<>();

        System.out.println("Testing create Room API");
        RestTemplate restTemplate = new RestTemplate();
        Room Room = new Room.Builder(true).roomDescr("single room").numBeds(1).hotel(hotel).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/rooms/create/", Room, Room.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void updateRoom()
    {
        List<Hotel> hotel = new ArrayList<>();

        System.out.println("Testing update Room API");
        RestTemplate restTemplate = new RestTemplate();
        Room Room = new Room.Builder(true).roomDescr("pent house").numBeds(2).hotel(hotel).build();
        restTemplate.put(REST_SERVICE_URI+"/rooms/update/1", Room);

        System.out.println(Room);
    }

    private static void deleteRoom()
    {
        System.out.println("Testing delete Room API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/rooms/delete/1");
    }

    private static void deleteAllRooms()
    {
        System.out.println("Testing delete Rooms API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/rooms/");
    }
}
