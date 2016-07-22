package za.ac.cput.hotelReservation.api;

import org.junit.Assert;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.domain.Bill;
import za.ac.cput.hotelReservation.domain.Reservation;
import za.ac.cput.hotelReservation.factory.BillFactory;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
public class BillApiTest
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
    private static void listAllBills()
    {
        System.out.println("Testing listAllBills API-----");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> BillMap = restTemplate.getForObject(REST_SERVICE_URI+"/bills/", List.class);

        if(BillMap != null)
        {
            for(LinkedHashMap<String, Object> map : BillMap)
            {
                System.out.println("Bill : id="+map.get("billId")+", Billing Item="+map.get("itemDescr")+", Total Amount="+map.get("totalAmount")+", Reservation="+map.get("reservation"));;
            }
        }
        else
        {
            System.out.println("No Bill exist");
        }
    }

    private static void getBill()
    {
        System.out.println("Testing getBill API");
        RestTemplate restTemplate = new RestTemplate();
        Bill Bill = restTemplate.getForObject(REST_SERVICE_URI+"/bills/1", Bill.class);
        System.out.println(Bill);
    }

    private static void createBill()
    {
        List<Reservation> reservation = new ArrayList<>();

        System.out.println("Testing create Bill API");
        RestTemplate restTemplate = new RestTemplate();
        Bill Bill = new Bill.Builder("2 bedroom").totalAmount(1800).reservation(reservation).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/bills/create/", Bill, Bill.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    private static void updateBill()
    {
        List<Reservation> reservation = new ArrayList<>();

        System.out.println("Testing update Bill API");
        RestTemplate restTemplate = new RestTemplate();

        Bill Bill = new Bill.Builder("2 bedroom").totalAmount(1200).reservation(reservation).build();

        restTemplate.put(REST_SERVICE_URI+"/bills/update/1", Bill);

        System.out.println(Bill);
    }

    private static void deleteBill()
    {
        System.out.println("Testing delete bill API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/bills/delete/1");
    }

    private static void deleteAllBill()
    {
        System.out.println("Testing delete bills API");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/bills/");
    }
}
