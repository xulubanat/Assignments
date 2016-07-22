package za.ac.cput.hotelReservation.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.BillFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by student on 2015/12/25.
 */
public class BillTest
{
    private float totalAmount;

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testCreate() throws Exception
    {
        List<Reservation> reservation = new ArrayList<>();

        Bill bill = BillFactory.createBill("2 bedroom",1200, reservation);

        Assert.assertEquals(String.valueOf(1200.00), String.valueOf(bill.getTotalAmount()));
    }

    @Test
    public void testUpdate() throws Exception
    {
        List<Reservation> reservation = new ArrayList<>();

        Bill bill = BillFactory.createBill("2 bedroom",1200, reservation);
        Bill newBill = new Bill.Builder(bill.getItemDescr()).copy(bill).totalAmount(1500).build();

        Assert.assertEquals(String.valueOf(1200.00), String.valueOf(bill.getTotalAmount()));
        Assert.assertEquals(String.valueOf(1500.00), String.valueOf(newBill.getTotalAmount()));
    }
}
