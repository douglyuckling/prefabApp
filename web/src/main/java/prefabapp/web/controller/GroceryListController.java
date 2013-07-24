package prefabapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import prefabapp.domain.GroceryListItem;
import prefabapp.services.GroceryListService;

import java.util.ArrayList;
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
    public List<GroceryListItem> getGroceryList() {
        return new ArrayList<>(groceryListService.getItems());
    }

    @RequestMapping(value = "/item", method = POST)
    @ResponseBody
    public GroceryListItem getGroceryList(GroceryListItem groceryListItem) {
        groceryListService.saveItem(groceryListItem);
        return groceryListItem;
    }

}
