package prefabapp.web.controller;

import dto.GroceryListItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import prefabapp.domain.GroceryListItem;
import prefabapp.services.GroceryListService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/data/grocerylist")
public class GroceryListController {

    @Autowired
    private GroceryListService groceryListService;

    @RequestMapping(value = {"","/"}, method = GET)
    @ResponseBody
    public List<GroceryListItemDto> getGroceryList() {
        Collection<GroceryListItem> domainObjets = groceryListService.getItems();
        List<GroceryListItemDto> dtos = new ArrayList<>(domainObjets.size());
        for (GroceryListItem groceryListItem : domainObjets) {
            dtos.add(GroceryListItemDto.fromDomainObject(groceryListItem));
        }
        return dtos;
    }

    @RequestMapping(value = {"", "/"}, method = POST)
    @ResponseBody
    public List<GroceryListItem> updateGroceryListItems(@RequestBody List<GroceryListItemDto> modifiedItemDtos) {
        List<GroceryListItem> modifiedItems = new ArrayList<>(modifiedItemDtos.size());
        for (GroceryListItemDto modifiedItemDto : modifiedItemDtos) {
            modifiedItems.add(modifiedItemDto.toDomainObject());
        }
        return new ArrayList<>(groceryListService.updateItems(modifiedItems));
    }

}
