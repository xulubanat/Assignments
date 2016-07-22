package za.ac.cput.hotelReservation.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.hotelReservation.domain.FacilitiesList;

import java.util.List;

/**
 * Created by student on 2016/07/17.
 */
public class PaymentMethodResource extends ResourceSupport
{
    private Long paymentMethodId;
    private String paymethod;

    private PaymentMethodResource()
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

    public PaymentMethodResource(Builder builder)
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

        public Builder copy(PaymentMethodResource value) {
            this.paymentMethodId = value.getPaymentMethodId();
            this.paymethod = value.getPaymethod();

            return this;
        }

        public PaymentMethodResource build()
        {
            return new PaymentMethodResource(this);
        }
    }
}
