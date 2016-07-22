package za.ac.cput.hotelReservation.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.hotelReservation.factory.PaymentMethodFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class PaymentMethodTest
{
    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testCreate() throws Exception
    {
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("Cash");

        Assert.assertEquals("Cash", paymentMethod.getPaymethod());
    }

    @Test
    public void testUpdate() throws Exception
    {
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("Cash");
        PaymentMethod newPaymentMethod = new PaymentMethod.Builder("Credit").build();

        Assert.assertEquals("Cash", paymentMethod.getPaymethod());
        Assert.assertEquals("Credit", newPaymentMethod.getPaymethod());
    }
}
