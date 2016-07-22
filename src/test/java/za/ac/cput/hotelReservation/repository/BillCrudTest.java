package za.ac.cput.hotelReservation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Bill;
import za.ac.cput.hotelReservation.domain.Reservation;
import za.ac.cput.hotelReservation.factory.BillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/12/27.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class BillCrudTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private BillRepo repository;

    @Test
    public void create() throws Exception
    {
        List<Reservation> reservation = new ArrayList<>();

        Bill bill = BillFactory.createBill("2 bedroom",1200, null);
        repository.save(bill);
        id = bill.getBillId();
        Assert.assertNotNull(bill.getBillId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Bill bill = repository.findOne(id);
        Assert.assertNotNull(bill.getBillId());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Bill bill = repository.findOne(id);
        repository.delete(bill);
        Bill deleteBill = repository.findOne(id);
        Assert.assertNull(deleteBill);
    }
}
