package za.ac.cput.hotelReservation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hotelReservation.domain.Hotel;

/**
 * Created by student on 2015/12/27.
 */
public interface HotelRepo extends CrudRepository<Hotel, Long>
{
}
