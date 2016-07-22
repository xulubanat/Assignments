package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2016/07/17.
 */
public class FacilitiesListResource extends ResourceSupport
{
    private Long facilitiesId;
    private String facilityDescr;

    private FacilitiesListResource()
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

    public FacilitiesListResource(Builder builder)
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

        public Builder copy(FacilitiesListResource value) {
            this.facilitiesId = value.getFacilitiesId();
            this.facilityDescr = value.getFacilityDescr();

            return this;
        }

        public FacilitiesListResource build()
        {
            return new FacilitiesListResource(this);
        }
    }
}
