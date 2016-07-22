package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2016/01/03.
 */
public class GuestResource extends ResourceSupport
{
    private Long resId;
    private String title;
    private String initials;
    private String fName;
    private String lName;
    private String contactNumber;
    private String emailAddress;

    private GuestResource()
    {
    }

    public Long getResId() {
        return resId;
    }

    public String getTitle() {
        return title;
    }

    public String getInitials() {
        return initials;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public GuestResource(Builder builder)
    {
        resId = builder.resId;
        title = builder.title;
        initials = builder.initials;
        fName = builder.fName;
        lName = builder.lName;
        contactNumber = builder.contactNumber;
        emailAddress = builder.emailAddress;
    }

    public static class Builder
    {
        private Long resId;
        private String title;
        private String initials;
        private String fName;
        private String lName;
        private String contactNumber;
        private String emailAddress;

        public Builder(String fName)
        {
            this.fName = fName;
        }

        public Builder resId(Long value)
        {
            this.resId = value;
            return this;
        }

        public Builder lName(String value)
        {
            this.lName = value;
            return this;
        }

        public Builder title(String value)
        {
            this.title = value;
            return this;
        }

        public Builder initials(String value)
        {
            this.initials = value;
            return this;
        }

        public Builder contactNumber(String value)
        {
            this.contactNumber = value;
            return this;
        }

        public Builder emailAddress(String value)
        {
            this.emailAddress = value;
            return this;
        }

        public Builder copy(GuestResource value)
        {
            this.resId = value.getResId();
            this.title = value.getTitle();
            this.initials = value.getInitials();
            this.fName = value.getfName();
            this.lName = value.getlName();
            this.contactNumber = value.getContactNumber();
            this.emailAddress = value.getEmailAddress();

            return this;
        }

        public GuestResource build()
        {
            return new GuestResource(this);
        }
    }
}
