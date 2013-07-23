package prefabapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import prefabapp.domain.GroceryListItem;
import prefabapp.domain.repository.GroceryListItemRepository;

import java.util.Collection;

public class GroceryListServiceImpl implements GroceryListService {

    @Autowired
    private GroceryListItemRepository repository;

    @Override
    public Collection<GroceryListItem> getItems() {
        return repository.getItems();
    }

    @Override
    public void saveItem(GroceryListItem item) {
        repository.saveItem(item);
    }

}
