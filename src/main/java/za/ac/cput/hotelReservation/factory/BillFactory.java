package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.Bill;
import za.ac.cput.hotelReservation.domain.Reservation;

import java.util.List;

/**
 * Created by student on 2015/12/25.
 */
public class BillFactory
{
    public static Bill createBill(float totalAmount, List<Reservation> reservation)
    {
        Bill bill = new Bill.Builder(totalAmount).reservation(reservation).build();
        return bill;
    }
}
