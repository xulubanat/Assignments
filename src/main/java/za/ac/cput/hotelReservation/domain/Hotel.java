package za.ac.cput.hotelReservation.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/12/25.
 */
@Entity
public class Hotel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String hotelName;
    private int streetNum;
    private String streetName;
    private String suburb;
    private String city;
    private String phoneNumber;
    private String webAddress;

    private Hotel()
    {
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public Hotel(Builder builder)
    {
        hotelName = builder.hotelName;
        streetNum = builder.streetNum;
        streetName = builder.streetName;
        suburb = builder.suburb;
        city = builder.city;
        phoneNumber = builder.phoneNumber;
        webAddress = builder.webAddress;
    }

    public static class Builder
    {
        private String hotelName;
        private int streetNum;
        private String streetName;
        private String suburb;
        private String city;
        private String phoneNumber;
        private String webAddress;

        public Builder(String hotelName)
        {
            this.hotelName = hotelName;
        }

        public Builder streetNum(int value)
        {
            this.streetNum = value;
            return this;
        }

        public Builder streetName(String value)
        {
            this.streetName = value;
            return this;
        }

        public Builder suburb(String value)
        {
            this.suburb = value;
            return this;
        }

        public Builder city(String value)
        {
            this.city = value;
            return this;
        }

        public Builder phoneNumber(String value)
        {
            this.phoneNumber = value;
            return this;
        }

        public Builder webAddress(String value)
        {
            this.webAddress = value;
            return this;
        }

        public Builder copy(Hotel value)
        {
            this.hotelName = value.getHotelName();
            this.streetNum = value.getStreetNum();
            this.streetName = value.getStreetName();
            this.suburb = value.getSuburb();
            this.city = value.getCity();
            this.phoneNumber = value.getPhoneNumber();
            this.webAddress = value.getWebAddress();

            return this;
        }

        public Hotel build()
        {
            return new Hotel(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (streetNum != hotel.streetNum) return false;
        if (city != null ? !city.equals(hotel.city) : hotel.city != null) return false;
        if (hotelName != null ? !hotelName.equals(hotel.hotelName) : hotel.hotelName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(hotel.phoneNumber) : hotel.phoneNumber != null) return false;
        if (streetName != null ? !streetName.equals(hotel.streetName) : hotel.streetName != null) return false;
        if (suburb != null ? !suburb.equals(hotel.suburb) : hotel.suburb != null) return false;
        if (webAddress != null ? !webAddress.equals(hotel.webAddress) : hotel.webAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hotelName != null ? hotelName.hashCode() : 0;
        result = 31 * result + streetNum;
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (suburb != null ? suburb.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (webAddress != null ? webAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", streetNum=" + streetNum +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", webAddress='" + webAddress + '\'' +
                '}';
    }
}
