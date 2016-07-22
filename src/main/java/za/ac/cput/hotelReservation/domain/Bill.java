package za.ac.cput.hotelReservation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
@Entity
public class Bill implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;
    private String itemDescr;
    private float totalAmount;
    @OneToOne(targetEntity = Reservation.class)
    @JoinColumn(name = "reservationId")
    private List<Reservation> reservation = new ArrayList<Reservation>();


    private Bill()
    {
    }

    public Long getBillId() {
        return billId;
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

    public Bill(Builder builder)
    {
        billId = builder.billId;
        itemDescr = builder.itemDescr;
        totalAmount = builder.totalAmount;
        reservation = builder.reservation;
    }

    public static class Builder
    {
        private Long billId;
        private String itemDescr;
        private float totalAmount;
        private List<Reservation> reservation;

        public Builder(String itemDescr)
        {
            this.itemDescr = itemDescr;
        }

        public Builder billId(Long value)
        {
            this.billId = value;
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

        public Builder copy(Bill value)
        {
            this.billId = value.getBillId();
            this.itemDescr = value.getItemDescr();
            this.totalAmount = value.getTotalAmount();
            this.reservation = value.getReservation();

            return this;
        }
        public Bill build()
        {
            return new Bill(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bill bill = (Bill) o;

        if (Float.compare(bill.totalAmount, totalAmount) != 0) return false;
        if (billId != null ? !billId.equals(bill.billId) : bill.billId != null) return false;
        if (itemDescr != null ? !itemDescr.equals(bill.itemDescr) : bill.itemDescr != null) return false;
        if (reservation != null ? !reservation.equals(bill.reservation) : bill.reservation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = billId != null ? billId.hashCode() : 0;
        result = 31 * result + (itemDescr != null ? itemDescr.hashCode() : 0);
        result = 31 * result + (totalAmount != +0.0f ? Float.floatToIntBits(totalAmount) : 0);
        result = 31 * result + (reservation != null ? reservation.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", itemDescr='" + itemDescr + '\'' +
                ", totalAmount=" + totalAmount +
                ", reservation=" + reservation +
                '}';
    }

}
