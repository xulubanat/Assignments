package za.ac.cput.hotelReservation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.hotelReservation.domain.Room;
import za.ac.cput.hotelReservation.service.RoomService;

import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
@RestController
@RequestMapping("/api/**")
public class RoomPage
{
    @Autowired
    private RoomService service;

    @RequestMapping(value = "/rooms/", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> listAllRooms() {
        List<Room> rooms = service.findAll();
        if (rooms.isEmpty())
        {
            return new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Room> getGuest(@PathVariable("id") long id)
    {
        System.out.println("Fetching Room id" + id);
        Room room = service.findById(id);
        if (room == null)
        {
            System.out.println("Room with id " + id + " not found");
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms/create/", method = RequestMethod.POST)
    public ResponseEntity<Void> createRoom(@RequestBody Room room, UriComponentsBuilder ucBuilder)
    {
        System.out.println("Creating Room " + room.getRoomId());
        service.save(room);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rooms/{id}").buildAndExpand(room.getRoomId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/rooms/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Room> updateRoom(@PathVariable("id") long id, @RequestBody Room room)
    {
        System.out.println("Updating Room " + id);
        Room currentRoom = service.findById(id);
        if (currentRoom == null)
        {
            System.out.println("Room with id " + id + " not found");
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }

        Room updatedRoom = new Room.Builder(currentRoom.isSmookingRoom()).copy(currentRoom).build();
        service.update(updatedRoom);
        return new ResponseEntity<Room>(updatedRoom, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") long id)
    {
        System.out.println("Fetching and Deleting Room with id " + id);
        Room room = service.findById(id);
        if (room == null)
        {
            System.out.println("Unable to delete, Room with id " + id + " not found");
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }

        service.delete(room);
        return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
    }
}
