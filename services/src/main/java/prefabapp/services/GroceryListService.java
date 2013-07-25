package prefabapp.services;

import prefabapp.domain.GroceryListItem;

import java.util.Collection;

public interface GroceryListService {

    Collection<GroceryListItem> getItems();

    Collection<GroceryListItem> updateItems(Collection<GroceryListItem> items);

}
