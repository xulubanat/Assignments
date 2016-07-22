package za.ac.cput.hotelReservation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hotelReservation.domain.RoomFacilities;

/**
 * Created by student on 2016/07/17.
 */
public interface RoomFacilitiesRepo extends CrudRepository<RoomFacilities, Long>
{
}
