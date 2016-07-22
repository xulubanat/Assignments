package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hotelReservation.domain.FacilitiesList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class RoomFacilitiesResource extends ResourceSupport
{
    private Long roomFacilityId;
    private String facilityDetails;
    @OneToOne(targetEntity = FacilitiesList.class)
    @JoinColumn(name = "facilitiesId")
    private List<FacilitiesList> facilitiesListList = new ArrayList<FacilitiesList>();

    private RoomFacilitiesResource()
    {
    }

    public Long getRoomFacilityId() {
        return roomFacilityId;
    }

    public void setRoomFacilityId(Long roomFacilityId) {
        this.roomFacilityId = roomFacilityId;
    }

    public String getFacilityDetails() {
        return facilityDetails;
    }

    public void setFacilityDetails(String facilityDetails) {
        this.facilityDetails = facilityDetails;
    }

    public List<FacilitiesList> getFacilitiesListList() {
        return facilitiesListList;
    }

    public void setFacilitiesListList(List<FacilitiesList> facilitiesListList) {
        this.facilitiesListList = facilitiesListList;
    }

    public RoomFacilitiesResource(Builder builder)
    {
        roomFacilityId = builder.roomFacilityId;
        facilityDetails = builder.facilityDetails;
        facilitiesListList = builder.facilitiesListList;
    }

    public static class Builder {
        private Long roomFacilityId;
        private String facilityDetails;
        private List<FacilitiesList> facilitiesListList;

        public Builder(String facilityDetails) {
            this.facilityDetails = facilityDetails;
        }

        public Builder roomFacilityId(Long value) {
            this.roomFacilityId = value;
            return this;
        }

        public Builder facilitiesListList(List<FacilitiesList> value) {
            this.facilitiesListList = value;
            return this;
        }

        public Builder copy(RoomFacilitiesResource value) {
            this.roomFacilityId = value.getRoomFacilityId();
            this.facilityDetails = value.getFacilityDetails();
            this.facilitiesListList = value.getFacilitiesListList();

            return this;
        }

        public RoomFacilitiesResource build()
        {
            return new RoomFacilitiesResource(this);
        }
    }
}
