package za.ac.cput.hotelReservation.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/12/25.
 */
@Entity
public class Guest implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;
    private String title;
    private String initials;
    private String fName;
    private String lName;
    private String contactNumber;
    private String emailAddress;

    private Guest()
    {
    }

    public Long getGuestId() {
        return guestId;
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

    public Guest(Builder builder)
    {
        guestId = builder.guestId;
        title = builder.title;
        initials = builder.initials;
        fName = builder.fName;
        lName = builder.lName;
        contactNumber = builder.contactNumber;
        emailAddress = builder.emailAddress;
    }

    public static class Builder
    {
        private Long guestId;
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

        public Builder guestId(Long value)
        {
            this.guestId = value;
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

        public Builder copy(Guest value)
        {
            this.guestId = value.getGuestId();
            this.title = value.getTitle();
            this.initials = value.getInitials();
            this.fName = value.getfName();
            this.lName = value.getlName();
            this.contactNumber = value.getContactNumber();
            this.emailAddress = value.getEmailAddress();

            return this;
        }

        public Guest build()
        {
            return new Guest(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guest guest = (Guest) o;

        if (contactNumber != null ? !contactNumber.equals(guest.contactNumber) : guest.contactNumber != null)
            return false;
        if (emailAddress != null ? !emailAddress.equals(guest.emailAddress) : guest.emailAddress != null) return false;
        if (fName != null ? !fName.equals(guest.fName) : guest.fName != null) return false;
        if (guestId != null ? !guestId.equals(guest.guestId) : guest.guestId != null) return false;
        if (initials != null ? !initials.equals(guest.initials) : guest.initials != null) return false;
        if (lName != null ? !lName.equals(guest.lName) : guest.lName != null) return false;
        if (title != null ? !title.equals(guest.title) : guest.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = guestId != null ? guestId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (initials != null ? initials.hashCode() : 0);
        result = 31 * result + (fName != null ? fName.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", title='" + title + '\'' +
                ", initials='" + initials + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
