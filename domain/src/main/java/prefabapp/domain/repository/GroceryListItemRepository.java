package prefabapp.domain.repository;

import prefabapp.domain.GroceryListItem;

import java.util.Collection;

public interface GroceryListItemRepository {

    Collection<GroceryListItem> getItems();

    Collection<GroceryListItem> saveItems(Collection<GroceryListItem> items);

    void deleteItemById(String itemId);

}
