package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Discount {

    private String discountCause;

    private BigDecimal discount;

    private Money amount;

    public Discount(String discountCause, BigDecimal discount, Money amount) {
        this.discountCause = discountCause;
        this.discount = discount;
        this.amount = amount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public Money getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Discount discount1 = (Discount) o;
        return discountCause.equals(discount1.discountCause) && discount.equals(discount1.discount) && amount.equals(discount1.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountCause, discount, amount);
    }
}
