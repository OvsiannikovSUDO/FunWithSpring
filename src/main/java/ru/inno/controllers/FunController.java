package ru.inno.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.inno.controllers.model.FunFactModel;
import ru.inno.services.FunService;

@Controller
public class FunController {

    private final FunService funService;

    public FunController(final FunService funService) {
        this.funService = funService;
    }

    @GetMapping("random")
    @ResponseBody
    public FunFactModel getFun() {
        return funService.getRandomFact();
    }

    // http://localhost:8080/?name=John
    @GetMapping
    public String getFunTest(final Model model, @RequestParam(defaultValue = "World") final String name) {
        model.addAttribute("name", name);
        return "welcome";
    }
}
