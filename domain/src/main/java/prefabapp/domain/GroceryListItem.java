package prefabapp.domain;

import java.util.UUID;

public class GroceryListItem {
    private String id;
    private String name;
    private int quantity;
    private String unit;

    private GroceryListItem() {
    }

    public GroceryListItem(String name, int quantity, String unit) {
        this.id = UUID.randomUUID().toString();
        this.name = name.trim();
        this.quantity = quantity;
        this.unit = unit;
    }

    public GroceryListItem(String name, String unit) {
        this(name, 1, unit);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroceryListItem that = (GroceryListItem) o;

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
