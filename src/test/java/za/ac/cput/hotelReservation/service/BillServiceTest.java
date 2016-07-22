package za.ac.cput.hotelReservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Assert;
import org.testng.annotations.Test;
import za.ac.cput.hotelReservation.App;
import za.ac.cput.hotelReservation.domain.Bill;
import za.ac.cput.hotelReservation.domain.Reservation;
import za.ac.cput.hotelReservation.factory.BillFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class BillServiceTest extends AbstractTestNGSpringContextTests
{
    private Long id;

    @Autowired
    private BillService service;

    @Test
    public void create() throws Exception
    {
        List<Reservation> reservation = new ArrayList<>();

        Bill bill = BillFactory.createBill("2 bedroom",1200, null);
        service.save(bill);
        id = bill.getBillId();
        Assert.assertNotNull(bill);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {
        Bill bill = service.findById(id);
        Assert.assertEquals(String.valueOf(1200.00), String.valueOf(bill.getTotalAmount()));
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception
    {
        Bill bill = service.findById(id);

        Bill newBill = new Bill.Builder(bill.getItemDescr()).copy(bill).totalAmount(1500).build();
        service.update(newBill);
        Bill updatedBill = service.findById(id);

        Assert.assertEquals(String.valueOf(1500.00), String.valueOf(updatedBill.getTotalAmount()));
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception
    {
        Bill bill = service.findById(id);
        service.delete(bill);
        Bill deletedBill = service.findById(id);
        Assert.assertNull(deletedBill);
    }
}
