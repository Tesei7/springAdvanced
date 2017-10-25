package advanced.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @RequestMapping(value = "/greetingModel", method = RequestMethod.GET)
    public String getGreeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(value = "/greetingMav", method = RequestMethod.GET)
    public ModelAndView getGreetingModelAndView(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        ModelAndView mav = new ModelAndView("greeting");
        mav.addObject("name", "dear " + name);
        return mav;
    }

    @RequestMapping(value = "/greetingMa", method = RequestMethod.GET)
    @ModelAttribute("name")
    public String getGreetingModelAttribute(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return "dearest " + name + "!!";
    }
}
