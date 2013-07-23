package prefabapp.domain.repository;

import prefabapp.domain.GroceryListItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class DummyGroceryListItemRepositoryImpl implements GroceryListItemRepository {

    private Map<String, GroceryListItem> items = new LinkedHashMap<>();

    public DummyGroceryListItemRepositoryImpl() {
        saveItem(new GroceryListItem("Milk (gallon)"));
        saveItem(new GroceryListItem("Eggs (dozen)"));
        saveItem(new GroceryListItem("Bread (loaf)", 2));
    }

    @Override
    public Collection<GroceryListItem> getItems() {
        return new ArrayList<>(items.values());
    }

    @Override
    public void saveItem(GroceryListItem item) {
        items.put(item.getId(), item);
    }

}
