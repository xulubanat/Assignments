package za.ac.cput.hotelReservation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2016/06/20.
 */
public class PaymentMethod implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentMethodId;
    private String paymethod;

    private PaymentMethod()
    {
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public PaymentMethod(Builder builder)
    {
        paymentMethodId = builder.paymentMethodId;
        paymethod = builder.paymethod;
    }

    public static class Builder {
        private Long paymentMethodId;
        private String paymethod;
        private List<FacilitiesList> facilitiesListList;

        public Builder(String paymethod) {
            this.paymethod = paymethod;
        }

        public Builder paymentMethodId(Long value) {
            this.paymentMethodId = value;
            return this;
        }

        public Builder copy(PaymentMethod value) {
            this.paymentMethodId = value.getPaymentMethodId();
            this.paymethod = value.getPaymethod();

            return this;
        }

        public PaymentMethod build()
        {
            return new PaymentMethod(this);
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
