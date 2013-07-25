package dto;

import prefabapp.domain.GroceryListItem;

public class GroceryListItemDto {
    private String id;
    private String name;
    private int quantity;

    public static GroceryListItemDto fromDomainObject(GroceryListItem groceryListItem) {
        GroceryListItemDto dto = new GroceryListItemDto();
        dto.id = groceryListItem.getId();
        dto.name = groceryListItem.getName();
        dto.quantity = groceryListItem.getQuantity();
        return dto;
    }

    public GroceryListItem toDomainObject() {
        return new GroceryListItem(this.name, this.quantity);
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

}
