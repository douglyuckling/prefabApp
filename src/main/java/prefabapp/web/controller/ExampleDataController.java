package prefabapp.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/data")
public class ExampleDataController {

    @Value("${application.web.data.text}")
    private String text;

    @RequestMapping(value = "/text", method = GET)
    @ResponseBody
    public String getText() {
        return text;
    }

}
