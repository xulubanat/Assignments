package za.ac.cput.hotelReservation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.hotelReservation.domain.Reservation;
import za.ac.cput.hotelReservation.service.ReservationService;

import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
@RestController
@RequestMapping("/api/**")
public class ReservationPage
{
    @Autowired
    private ReservationService service;

    @RequestMapping(value = "/reservations/", method = RequestMethod.GET)
    public ResponseEntity<List<Reservation>> listAllReservations() {
        List<Reservation> reservations = service.findAll();
        if (reservations.isEmpty())
        {
            return new ResponseEntity<List<Reservation>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
    }

    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> getReservation(@PathVariable("id") long id)
    {
        System.out.println("Fetching Reservation id" + id);
        Reservation reservation = service.findById(id);
        if (reservation == null)
        {
            System.out.println("Reservation with id " + id + " not found");
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }

    @RequestMapping(value = "/reservations/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createReservation(@RequestBody Reservation reservation, UriComponentsBuilder ucBuilder)
    {
        System.out.println("Creating Reservation " + reservation.getReservationId());
        service.save(reservation);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/reservations/{id}").buildAndExpand(reservation.getReservationId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/reservations/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation)
    {
        System.out.println("Updating Reservation " + id);
        Reservation currentReservation = service.findById(id);
        if (currentReservation == null)
        {
            System.out.println("Reservation with id " + id + " not found");
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }

        Reservation updatedReservation = new Reservation.Builder(currentReservation.getArrivalDate()).copy(currentReservation).build();
        service.update(updatedReservation);
        return new ResponseEntity<Reservation>(updatedReservation, HttpStatus.OK);
    }

    @RequestMapping(value = "/reservations/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") long id)
    {
        System.out.println("Fetching and Deleting Reservation with id " + id);
        Reservation reservation = service.findById(id);
        if (reservation == null)
        {
            System.out.println("Unable to delete, Reservation with id " + id + " not found");
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }

        service.delete(reservation);
        return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
    }
}
