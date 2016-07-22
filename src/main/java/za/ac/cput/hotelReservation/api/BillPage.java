package za.ac.cput.hotelReservation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.hotelReservation.domain.Bill;
import za.ac.cput.hotelReservation.service.BillService;

import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
@RestController
@RequestMapping("/api/**")
public class BillPage
{
    @Autowired
    private BillService service;

    @RequestMapping(value = "/bills/", method = RequestMethod.GET)
    public ResponseEntity<List<Bill>> listAllBills() {
        List<Bill> bills = service.findAll();
        if (bills.isEmpty())
        {
            return new ResponseEntity<List<Bill>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Bill>>(bills, HttpStatus.OK);
    }

    @RequestMapping(value = "/bills/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Bill> getBill(@PathVariable("id") long id)
    {
        System.out.println("Fetching Bill id" + id);
        Bill bill = service.findById(id);
        if (bill == null)
        {
            System.out.println("Bill with id " + id + " not found");
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Bill>(bill, HttpStatus.OK);
    }

    @RequestMapping(value = "/bills/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBill(@RequestBody Bill bill, UriComponentsBuilder ucBuilder)
    {
        System.out.println("Creating Bill " + bill.getBillId());
        service.save(bill);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/bill/{id}").buildAndExpand(bill.getBillId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bills/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Bill> updateBill(@PathVariable("id") long id, @RequestBody Bill bill)
    {
        System.out.println("Updating Bill " + id);
        Bill currentBill = service.findById(id);
        if (currentBill == null)
        {
            System.out.println("Bill with id " + id + " not found");
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }

        Bill updatedBill = new Bill.Builder(currentBill.getItemDescr()).copy(currentBill).build();
        service.update(updatedBill);
        return new ResponseEntity<Bill>(updatedBill, HttpStatus.OK);
    }

    @RequestMapping(value = "/bills/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Bill> deleteBill(@PathVariable("id") long id)
    {
        System.out.println("Fetching and Deleting Bill with id " + id);
        Bill bill = service.findById(id);
        if (bill == null)
        {
            System.out.println("Unable to delete, Bill with id " + id + " not found");
            return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
        }

        service.delete(bill);
        return new ResponseEntity<Bill>(HttpStatus.NO_CONTENT);
    }
}
