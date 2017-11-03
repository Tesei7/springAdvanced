package advanced.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {

    @RequestMapping(value = {"/add", "/edit"}, method = {RequestMethod.POST})
    public String addPerson(@ModelAttribute("person") Person person) {
        return "redirect:view?id=1";
    }

    @ModelAttribute("person")
    public Person getPerson(@RequestParam(value = "id", required = false) Integer id) {
        Person person = null;
        return person == null ? new Person() : person;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewPersonForm() {
        return "person/view";
    }

    @RequestMapping(value = "/edit", method = {RequestMethod.GET})
    public String showEditForm() {
        return "editPerson";
    }
}
