package za.ac.cput.hotelReservation.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.hotelReservation.domain.Bill;
import za.ac.cput.hotelReservation.repository.BillRepo;
import za.ac.cput.hotelReservation.services.BillService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/12/27.
 */
public class BillServiceImpl implements BillService
{
    @Autowired
    BillRepo repository;

    @Override
    public List<Bill> getBill()
    {
        List<Bill> allBills = new ArrayList<>();

        Iterable<Bill> bills = repository.findAll();
        for(Bill bill : bills)
        {
            allBills.add(bill);
        }
        return allBills;
    }
}
