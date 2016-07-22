package za.ac.cput.hotelReservation.api;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.domain.Reservation;
import za.ac.cput.hotelReservation.factory.ReservationFactory;

import java.net.URI;
import java.util.*;

/**
 * Created by student on 2016/01/03.
 */
public class ReservationApiTest
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
    private static void listAllReservations()
    {
        System.out.println("Testing listAllReservations API-----");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> ReservationMap = restTemplate.getForObject(REST_SERVICE_URI+"/reservations/", List.class);

        if(ReservationMap != null)
        {
            for(LinkedHashMap<String, Object> map : ReservationMap)
            {
                System.out.println("Reservation : id="+map.get("reservationId")+", Arrival Date ="+map.get("arrivalDate")+", Depart Date ="+map.get("departDate")+",Smooking Room="+map.get("smookingRoom")+",Number Of Beds ="+map.get("numOfBed")+",High Or Low Floor ="+map.get("highOrLowFloor")+",Hotel ="+map.get("hotel")+", Guest ="+map.get("guest"));;

            }
        }
        else
        {
            System.out.println("No Reservation exist");
        }
    }

    private static void getReservation()
    {
        System.out.println("Testing getReservation API");
        RestTemplate restTemplate = new RestTemplate();
        Reservation Reservation= restTemplate.getForObject(REST_SERVICE_URI+"/reservations/1", Reservation.class);
        System.out.println(Reservation);
    }

    private static void createReservation()
    {
        Map<String, String> dates = new HashMap<>();
        List<Hotel> hotel = new ArrayList<>();
        List<Guest> guest = new ArrayList<>();

        dates.put("arrivalDate", "28-Dec-2015");
        dates.put("departDate", "29-Dec-2015");

        System.out.println("Testing create Reservation API");
        RestTemplate restTemplate = new RestTemplate();

        Reservation Reservation = new Reservation.Builder(dates.get("arrivalDate")).departDate(dates.get("departDate")).smookingRoom(false).numOfBed(2).highOrLowFloor("high").hotel(hotel).guest(guest).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/reservations/create/", Reservation, Reservation.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void updateReservation()
    {
        Map<String, String> dates = new HashMap<>();
        List<Hotel> hotel = new ArrayList<>();
        List<Guest> guest = new ArrayList<>();

        dates.put("arrivalDate", "28-Dec-2015");
        dates.put("departDate", "30-Dec-2015");

        System.out.println("Testing update Reservation API");
        RestTemplate restTemplate = new RestTemplate();
        Reservation Reservation = new Reservation.Builder(dates.get("arrivalDate")).departDate(dates.get("departDate")).smookingRoom(true).numOfBed(2).highOrLowFloor("high").hotel(hotel).guest(guest).build();
        restTemplate.put(REST_SERVICE_URI+"/reservations/update/1", Reservation);

        System.out.println(Reservation);
    }

    private static void deleteReservation()
    {
        System.out.println("Testing delete Reservation API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/reservations/delete/1");
    }

    private static void deleteAllReservations()
    {
        System.out.println("Testing delete Reservations API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/reservations/");
    }
}
