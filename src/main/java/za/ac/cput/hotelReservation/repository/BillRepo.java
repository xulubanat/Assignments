package za.ac.cput.hotelReservation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hotelReservation.domain.Bill;

/**
 * Created by student on 2015/12/27.
 */
public interface BillRepo extends CrudRepository<Bill, Long>
{
}
