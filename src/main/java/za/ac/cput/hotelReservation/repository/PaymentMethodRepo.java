package za.ac.cput.hotelReservation.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.hotelReservation.domain.PaymentMethod;

/**
 * Created by student on 2016/07/17.
 */
public interface PaymentMethodRepo extends CrudRepository<PaymentMethod, Long> {
}
