package advanced.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HelloController {
    @Autowired
    private CalculationService calculationService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getExampleHTML(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("isIlia", principal.getName().equals("Ilia"));
        }
        if (principal != null && !principal.getName().equals("User")) {
            model.addAttribute("sum", calculationService.calculate(2, 2));
        }
        return "hello";
    }
}
