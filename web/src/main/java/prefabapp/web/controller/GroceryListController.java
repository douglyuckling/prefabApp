package prefabapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import prefabapp.domain.GroceryListItem;
import prefabapp.services.GroceryListService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@RequestMapping("/data/grocerylist")
public class GroceryListController {

    @Autowired
    private GroceryListService groceryListService;

    @RequestMapping(value = {"","/"}, method = GET)
    @ResponseBody
    public List<GroceryListItem> getGroceryList() {
        return new ArrayList<>(groceryListService.getItems());
    }

    @RequestMapping(value = {"", "/"}, method = POST)
    @ResponseBody
    public List<GroceryListItem> createGroceryListItems(@RequestBody List<GroceryListItem> newItems) {
        return new ArrayList<>(groceryListService.saveItems(newItems));
    }

    @RequestMapping(value = {"/{itemId}"}, method = PUT)
    @ResponseBody
    public List<GroceryListItem> updateGroceryListItem(@PathVariable("itemId") String itemId,
                                                       @RequestBody List<GroceryListItem> modifiedItems) {
        return new ArrayList<>(groceryListService.saveItems(modifiedItems));
    }

    @RequestMapping(value = {"/{itemId}"}, method = DELETE)
    @ResponseBody
    public void deleteGroceryListItem(@PathVariable("itemId") String itemId) {
        groceryListService.deleteItemById(itemId);
    }

}
