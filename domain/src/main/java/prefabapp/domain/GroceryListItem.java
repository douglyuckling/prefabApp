package prefabapp.domain;

import java.util.UUID;

public class GroceryListItem {
    private String id;
    private String name;
    private int quantity;

    private GroceryListItem() {
    }

    public GroceryListItem(String name, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.name = name.trim();
        this.quantity = quantity;
    }

    public GroceryListItem(String name) {
        this(name, 1);
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
