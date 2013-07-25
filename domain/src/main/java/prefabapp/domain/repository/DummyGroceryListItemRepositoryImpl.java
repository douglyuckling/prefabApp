package prefabapp.domain.repository;

import prefabapp.domain.GroceryListItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DummyGroceryListItemRepositoryImpl implements GroceryListItemRepository {

    private Map<String, GroceryListItem> itemsById = new LinkedHashMap<>();

    public DummyGroceryListItemRepositoryImpl() {
        storeItem(new GroceryListItem("Milk (gallon)"));
        storeItem(new GroceryListItem("Eggs (dozen)"));
        storeItem(new GroceryListItem("Bread (loaf)", 2));
    }

    @Override
    public Collection<GroceryListItem> getItems() {
        return new ArrayList<>(itemsById.values());
    }

    @Override
    public void updateItems(Collection<GroceryListItem> items) {
        for (GroceryListItem item : items) {
            storeItem(item);
        }
    }

    private void storeItem(GroceryListItem item) {
        this.itemsById.put(item.getId(), item);
    }

}
