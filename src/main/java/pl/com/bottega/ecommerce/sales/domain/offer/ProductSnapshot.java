package pl.com.bottega.ecommerce.sales.domain.offer;

import java.util.Date;
import java.util.Objects;

public class ProductSnapshot {

    private String id;
    private Date snapshotDate;
    private String type;
    private String name;
    private Money price;

    public ProductSnapshot(String id, Date snapshotDate, String type, String name, Money price) {
        this.id = id;
        this.snapshotDate = snapshotDate;
        this.type = type;
        this.name = name;
        this.price = price;
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

    public Money getPrice() {
        return price;
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
               && price.equals(that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, snapshotDate, type, name, price);
    }
}
