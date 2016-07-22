package za.ac.cput.hotelReservation.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2016/06/20.
 */
public class FacilitiesList implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long facilitiesId;
    private String facilityDescr;

    private FacilitiesList()
    {
    }

    public Long getFacilitiesId() {
        return facilitiesId;
    }

    public void setFacilitiesId(Long facilitiesId) {
        this.facilitiesId = facilitiesId;
    }

    public String getFacilityDescr() {
        return facilityDescr;
    }

    public void setFacilityDescr(String facilityDescr) {
        this.facilityDescr = facilityDescr;
    }

    public FacilitiesList(Builder builder)
    {
        facilitiesId = builder.facilitiesId;
        facilityDescr = builder.facilityDescr;
    }

    public static class Builder {
        private Long facilitiesId;
        private String facilityDescr;

        public Builder(String facilityDescr) {
            this.facilityDescr = facilityDescr;
        }

        public Builder facilitiesId(Long value) {
            this.facilitiesId = value;
            return this;
        }

        public Builder copy(FacilitiesList value) {
            this.facilitiesId = value.getFacilitiesId();
            this.facilityDescr = value.getFacilityDescr();

            return this;
        }

        public FacilitiesList build()
        {
            return new FacilitiesList(this);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
