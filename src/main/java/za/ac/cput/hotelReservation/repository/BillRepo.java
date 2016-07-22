package za.ac.cput.hotelReservation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hotelReservation.domain.Bill;

/**
 * Created by student on 2016/06/20.
 */
public interface BillRepo extends CrudRepository<Bill, Long>
{
}
