package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.PaymentMethod;

import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class PaymentMethodFactory
{
    public static PaymentMethod createPaymentMethod(String paymethod)
    {
        PaymentMethod paymentMethod = new PaymentMethod.Builder(paymethod).build();
        return paymentMethod;
    }
}
