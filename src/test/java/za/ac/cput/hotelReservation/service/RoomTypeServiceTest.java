package za.ac.cput.hotelReservation.service;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.hotelReservation.App;

/**
 * Created by student on 2016/07/17.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class RoomTypeServiceTest extends AbstractTestNGSpringContextTests
{
}
