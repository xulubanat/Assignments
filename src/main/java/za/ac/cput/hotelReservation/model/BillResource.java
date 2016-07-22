package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hotelReservation.domain.Reservation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/01/03.
 */
public class BillResource extends ResourceSupport
{
    private Long resId;
    private String itemDescr;
    private float totalAmount;
    private List<Reservation> reservation = new ArrayList<Reservation>();

    private BillResource()
    {
    }

    public Long getResId() {
        return resId;
    }

    public String getItemDescr() {
        return itemDescr;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public BillResource(Builder builder)
    {
        resId = builder.resId;
        itemDescr = builder.itemDescr;
        totalAmount = builder.totalAmount;
        reservation = builder.reservation;
    }

    public static class Builder
    {
        private Long resId;
        private String itemDescr;
        private float totalAmount;
        private List<Reservation> reservation;

        public Builder(String itemDescr)
        {
            this.itemDescr = itemDescr;
        }

        public Builder resId(Long value)
        {
            this.resId = value;
            return this;
        }

        public Builder totalAmount(float value)
        {
            this.totalAmount = value;
            return this;
        }

        public Builder reservation(List<Reservation> value)
        {
            this.reservation = value;
            return  this;
        }

        public Builder copy(BillResource value)
        {
            this.resId = value.getResId();
            this.itemDescr = value.getItemDescr();
            this.totalAmount = value.getTotalAmount();
            this.reservation = value.getReservation();

            return this;
        }
        public BillResource build()
        {
            return new BillResource(this);
        }
    }
}
