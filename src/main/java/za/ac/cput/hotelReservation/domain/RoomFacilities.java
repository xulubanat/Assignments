package za.ac.cput.hotelReservation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
public class RoomFacilities implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roomFacilityId;
    private String facilityDetails;
    @OneToOne(targetEntity = FacilitiesList.class)
    @JoinColumn(name = "facilitiesId")
    private List<FacilitiesList> facilitiesListList = new ArrayList<FacilitiesList>();

    private RoomFacilities()
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

    public RoomFacilities(Builder builder)
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

        public Builder copy(RoomFacilities value) {
            this.roomFacilityId = value.getRoomFacilityId();
            this.facilityDetails = value.getFacilityDetails();
            this.facilitiesListList = value.getFacilitiesListList();

            return this;
        }

        public RoomFacilities build()
        {
            return new RoomFacilities(this);
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
