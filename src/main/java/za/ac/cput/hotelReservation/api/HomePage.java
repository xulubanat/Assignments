package za.ac.cput.hotelReservation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.hotelReservation.domain.Hotel;
import za.ac.cput.hotelReservation.service.HotelService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2016/01/03.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage
{
    @Autowired
    private HotelService service;

    Map<String, String> newAddress = new HashMap<>();
    Map<String, String> contact = new HashMap<>();

    @RequestMapping(value = "/hotels/", method = RequestMethod.GET)
    public ResponseEntity<List<Hotel>> listAllHotels() {
        List<Hotel> hotels = service.findAll();
        if (hotels.isEmpty())
        {
            return new ResponseEntity<List<Hotel>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotels/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hotel> getHotel(@PathVariable("id") long id)
    {
        System.out.println("Fetching Hotel id" + id);
        Hotel hotel = service.findById(id);
        if (hotel == null)
        {
            System.out.println("Hotel with id " + id + " not found");
            return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotels/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createHotel(@RequestBody Hotel hotel, UriComponentsBuilder ucBuilder)
    {
        System.out.println("Creating Hotel " + hotel.getHotelName());
        service.save(hotel);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/hotel/{id}").buildAndExpand(hotel.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/hotels/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Hotel> updateHotel(@PathVariable("id") long id, @RequestBody Hotel hotel)
    {
        System.out.println("Updating Hotel " + id);
        Hotel currentHotel = service.findById(id);
        if (currentHotel == null)
        {
            System.out.println("Hotel with id " + id + " not found");
            return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
        }

        Hotel updatedHotel = new Hotel.Builder(currentHotel.getHotelName()).copy(currentHotel).build();
        service.update(updatedHotel);
        return new ResponseEntity<Hotel>(updatedHotel, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotels/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") long id)
    {
        System.out.println("Fetching and Deleting Hotel with id " + id);
        Hotel hotel = service.findById(id);
        if (hotel == null)
        {
            System.out.println("Unable to delete, Hotel with id " + id + " not found");
            return new ResponseEntity<Hotel>(HttpStatus.NOT_FOUND);
        }

        service.delete(hotel);
        return new ResponseEntity<Hotel>(HttpStatus.NO_CONTENT);
    }
}
