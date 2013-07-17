package prefabapp.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class ExampleContentController {

    @Value("${application.web.content.message}")
    private String message;

    @RequestMapping(value = "/index.html", method = GET)
    public ModelAndView getIndex() {
        ModelAndView model = new ModelAndView("index");
        model.addObject("message", message);
        return model;
    }

}
