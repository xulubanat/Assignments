package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.Bill;
import za.ac.cput.hotelReservation.repository.BillRepo;
import za.ac.cput.hotelReservation.service.BillService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
@Service
public class BillServiceImpl implements BillService
{
    @Autowired
    private BillRepo repository;

    @Override
    public Bill findById(Long id)
    {
        return repository.findOne(id);
    }

    @Override
    public Bill save(Bill entity)
    {
        return repository.save(entity);
    }

    @Override
    public Bill update(Bill entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Bill entity)
    {
        repository.delete(entity);
    }

    @Override
    public List<Bill> findAll()
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
