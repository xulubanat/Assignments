package za.ac.cput.hotelReservation.factory;

import za.ac.cput.hotelReservation.domain.Hotel;

import java.util.Map;

/**
 * Created by student on 2015/12/25.
 */
public class HotelFactory
{
    public static Hotel createHotel(String hotelName, int streetNum, Map<String, String> address, String city, Map<String, String> contact)
    {
        Hotel hotel = new Hotel.Builder(hotelName).streetNum(streetNum).streetName(address.get("streetName")).suburb(address.get("suburb")).city(city).phoneNumber(contact.get("phoneNumber")).webAddress(contact.get("webAddress")).build();
        return hotel;
    }
}
