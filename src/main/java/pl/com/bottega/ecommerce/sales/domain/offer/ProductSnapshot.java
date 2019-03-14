package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class ProductSnapshot {
    private String id;
    private Date snapshotDate;
    private String type;
    private String name;
    private BigDecimal productPrice;


    public ProductSnapshot(String id, Date snapshotDate, String type, String name, BigDecimal productPrice) {
        this.id = id;
        this.snapshotDate = snapshotDate;
        this.type = type;
        this.name = name;
        this.productPrice = productPrice;
    }

    public String getId() {
        return id;
    }

    public Date getSnapshotDate() {
        return snapshotDate;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProductSnapshot that = (ProductSnapshot) o;
        return id.equals(that.id)
               && snapshotDate.equals(that.snapshotDate)
               && type.equals(that.type)
               && name.equals(that.name)
               && productPrice.equals(that.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, snapshotDate, type, name, productPrice);
    }
}
