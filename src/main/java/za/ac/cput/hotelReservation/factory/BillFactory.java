package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.Bill;
import za.ac.cput.hotelReservation.domain.Reservation;

import java.util.List;

/**
 * Created by student on 2015/12/25.
 */
public class BillFactory
{
    public static Bill createBill(String itemDescr,float totalAmount, List<Reservation> reservation)
    {
        Bill bill = new Bill.Builder(itemDescr).totalAmount(totalAmount).reservation(reservation).build();
        return bill;
    }
}
