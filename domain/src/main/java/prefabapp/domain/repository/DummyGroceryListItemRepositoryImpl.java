package prefabapp.domain.repository;

import org.springframework.util.StringUtils;
import prefabapp.domain.GroceryListItem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DummyGroceryListItemRepositoryImpl implements GroceryListItemRepository {

    private Map<String, GroceryListItem> itemsById = new LinkedHashMap<>();

    public DummyGroceryListItemRepositoryImpl() {
        storeItem(new GroceryListItem("milk", "gallon"));
        storeItem(new GroceryListItem("eggs", 2, "dozen"));
        storeItem(new GroceryListItem("bread", "loaf"));
    }

    @Override
    public Collection<GroceryListItem> getItems() {
        return new ArrayList<>(itemsById.values());
    }

    @Override
    public Collection<GroceryListItem> saveItems(Collection<GroceryListItem> items) {
        List<GroceryListItem> savedItems = new ArrayList<>(items.size());
        for (GroceryListItem item : items) {
            if (!StringUtils.hasText(item.getId())) {
                item = new GroceryListItem(item.getName(), item.getQuantity(), item.getUnit());
            }
            savedItems.add(item);
            storeItem(item);
        }
        return savedItems;
    }

    @Override
    public void deleteItemById(String itemId) {
        itemsById.remove(itemId);
    }

    private void storeItem(GroceryListItem item) {
        this.itemsById.put(item.getId(), item);
    }

}
