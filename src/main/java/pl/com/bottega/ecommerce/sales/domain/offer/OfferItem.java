/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    private ProductSnapshot productSnapshot;

    private int quantity;

    private Money totalCost;

    // discount
    private String discountCause;

    private BigDecimal discount;

    public OfferItem(ProductSnapshot productSnapshot, int quantity) {
        this(productSnapshot, quantity, null, null);
    }

    public OfferItem(ProductSnapshot productSnapshot, int quantity, BigDecimal discount, String discountCause) {

        this.quantity = quantity;
        this.discount = discount;
        this.discountCause = discountCause;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(discount);
        }

        this.totalCost = new Money(productSnapshot.getPrice().getProductPrice().multiply(new BigDecimal(quantity)).subtract(discountValue),
                null);
    }

    public ProductSnapshot getProductSnapshot() {
        return productSnapshot;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getDiscountCause() {
        return discountCause;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discount, discountCause, productSnapshot, quantity, totalCost);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OfferItem other = (OfferItem) obj;
        return Objects.equals(discount, other.discount) && Objects.equals(discountCause, other.discountCause) && Objects.equals(
                productSnapshot, other.productSnapshot) && quantity == other.quantity && Objects.equals(totalCost, other.totalCost);
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {

        if (productSnapshot != null) {
            if (!productSnapshot.equals(other.productSnapshot)) {
                return false;
            }
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getProductPrice().compareTo(other.totalCost.getProductPrice()) > 0) {
            max = totalCost.getProductPrice();
            min = other.totalCost.getProductPrice();
        } else {
            max = other.totalCost.getProductPrice();
            min = totalCost.getProductPrice();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}
