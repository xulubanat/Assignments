package za.ac.cput.hotelReservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.hotelReservation.domain.PaymentMethod;
import za.ac.cput.hotelReservation.repository.PaymentMethodRepo;
import za.ac.cput.hotelReservation.service.PaymentMethodService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
@Service
public class PaymentMethodServiceImpl implements PaymentMethodService
{
    @Autowired
    PaymentMethodRepo repository;

    @Override
    public PaymentMethod findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public PaymentMethod save(PaymentMethod entity) {
        return repository.save(entity);
    }

    @Override
    public PaymentMethod update(PaymentMethod entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(PaymentMethod entity) {
        repository.delete(entity);
    }

    @Override
    public List<PaymentMethod> findAll() {
        List<PaymentMethod> allPaymentMethods = new ArrayList<>();

        Iterable<PaymentMethod> paymentMethods = repository.findAll();
        for(PaymentMethod paymentMethod : paymentMethods)
        {
            allPaymentMethods.add(paymentMethod);
        }
        return allPaymentMethods;
    }
}
