package za.ac.cput.hotelReservation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.hotelReservation.domain.Guest;
import za.ac.cput.hotelReservation.service.GuestService;

import java.util.List;

/**
 * Created by student on 2016/01/03.
 */

@RestController
@RequestMapping("/api/**")
public class GuestPage 
{
    @Autowired
    private GuestService service;

    @RequestMapping(value = "/guests/", method = RequestMethod.GET)
    public ResponseEntity<List<Guest>> listAllGuests() {
        List<Guest> guests = service.findAll();
        if (guests.isEmpty())
        {
            return new ResponseEntity<List<Guest>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Guest>>(guests, HttpStatus.OK);
    }

    @RequestMapping(value = "/guests/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guest> getGuest(@PathVariable("id") long id)
    {
        System.out.println("Fetching Guest id" + id);
        Guest guest = service.findById(id);
        if (guest == null)
        {
            System.out.println("Guest with id " + id + " not found");
            return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Guest>(guest, HttpStatus.OK);
    }

    @RequestMapping(value = "/guests/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createGuest(@RequestBody Guest guest, UriComponentsBuilder ucBuilder)
    {
        System.out.println("Creating Guest " + guest.getGuestId());
        service.save(guest);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/guest/{id}").buildAndExpand(guest.getGuestId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/guests/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Guest> updateGuest(@PathVariable("id") long id, @RequestBody Guest guest)
    {
        System.out.println("Updating Guest " + id);
        Guest currentGuest = service.findById(id);
        if (currentGuest == null)
        {
            System.out.println("Guest with id " + id + " not found");
            return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);
        }

        Guest updatedGuest = new Guest.Builder(currentGuest.getfName()).copy(currentGuest).build();
        service.update(updatedGuest);
        return new ResponseEntity<Guest>(updatedGuest, HttpStatus.OK);
    }

    @RequestMapping(value = "/guests/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Guest> deleteGuest(@PathVariable("id") long id)
    {
        System.out.println("Fetching and Deleting Guest with id " + id);
        Guest guest = service.findById(id);
        if (guest == null)
        {
            System.out.println("Unable to delete, Guest with id " + id + " not found");
            return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);
        }

        service.delete(guest);
        return new ResponseEntity<Guest>(HttpStatus.NO_CONTENT);
    }
}
