package za.ac.cput.hotelReservation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hotelReservation.domain.FacilitiesList;
import za.ac.cput.hotelReservation.domain.Guest;

/**
 * Created by student on 2016/06/20.
 */
public interface FacilitiesListRepo extends CrudRepository<FacilitiesList, Long>
{
}
