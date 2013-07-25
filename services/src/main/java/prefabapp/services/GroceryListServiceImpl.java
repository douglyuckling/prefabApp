package prefabapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import prefabapp.domain.GroceryListItem;
import prefabapp.domain.repository.GroceryListItemRepository;

import java.util.ArrayList;
import java.util.Collection;

public class GroceryListServiceImpl implements GroceryListService {

    @Autowired
    private GroceryListItemRepository repository;

    @Override
    public Collection<GroceryListItem> getItems() {
        return repository.getItems();
    }

    @Override
    public Collection<GroceryListItem> updateItems(Collection<GroceryListItem> items) {
        repository.updateItems(items);
        return new ArrayList<>(items);
    }

}
