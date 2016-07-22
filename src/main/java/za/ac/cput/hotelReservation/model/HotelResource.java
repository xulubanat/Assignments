package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2016/01/03.
 */
public class HotelResource extends ResourceSupport
{
    private Long resid;
    private String hotelName;
    private int streetNum;
    private String streetName;
    private String suburb;
    private String city;
    private String phoneNumber;
    private String webAddress;

    private HotelResource()
    {
    }

    public Long getResid() {
        return resid;
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

    public HotelResource(Builder builder)
    {
        resid = builder.resid;
        hotelName = builder.hotelName;
        streetNum = builder.streetNum;
        streetName = builder.streetName;
        suburb = builder.suburb;
        city = builder.city;
        phoneNumber = builder.phoneNumber;
        webAddress = builder.webAddress;
    }

    public static class Builder {
        private String hotelName;
        private int streetNum;
        private String streetName;
        private String suburb;
        private String city;
        private String phoneNumber;
        private String webAddress;
        private Long resid;

        public Builder(String hotelName) {
            this.hotelName = hotelName;
        }

        public Builder streetNum(int value) {
            this.streetNum = value;
            return this;
        }

        public Builder resid(Long value) {
            this.resid = value;
            return this;
        }

        public Builder streetName(String value) {
            this.streetName = value;
            return this;
        }

        public Builder suburb(String value) {
            this.suburb = value;
            return this;
        }

        public Builder city(String value) {
            this.city = value;
            return this;
        }

        public Builder phoneNumber(String value) {
            this.phoneNumber = value;
            return this;
        }

        public Builder webAddress(String value) {
            this.webAddress = value;
            return this;
        }

        public Builder copy(HotelResource value) {
            this.resid = value.getResid();
            this.hotelName = value.getHotelName();
            this.streetNum = value.getStreetNum();
            this.streetName = value.getStreetName();
            this.suburb = value.getSuburb();
            this.city = value.getCity();
            this.phoneNumber = value.getPhoneNumber();
            this.webAddress = value.getWebAddress();

            return this;
        }

        public HotelResource build() {
            return new HotelResource(this);
        }
    }
}
