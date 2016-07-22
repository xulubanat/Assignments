package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.PaymentMethod;
import za.ac.cput.hotelReservation.factory.PaymentMethodFactory;

/**
 * Created by student on 2016/07/17.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class PaymentMethodCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private PaymentMethodRepo repository;

    @Test
    public void create() throws Exception
    {
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod("Cash");
        repository.save(paymentMethod);
        id = paymentMethod.getPaymentMethodId();
        Assert.assertNotNull(paymentMethod.getPaymentMethodId());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        PaymentMethod paymentMethod = repository.findOne(id);
        Assert.assertNotNull(paymentMethod.getPaymentMethodId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        PaymentMethod paymentMethod = repository.findOne(id);
        repository.delete(paymentMethod);
        PaymentMethod deletePaymentMethod = repository.findOne(id);
        Assert.assertNull(deletePaymentMethod);
    }
}
