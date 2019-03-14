package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

    private BigDecimal productPrice;
    private String currency;

    public Money(BigDecimal productPrice, String currency) {
        this.productPrice = productPrice;
        this.currency = currency;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Money money = (Money) o;
        return productPrice.equals(money.productPrice) && currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPrice, currency);
    }
}
