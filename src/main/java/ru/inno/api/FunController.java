package ru.inno.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.services.FunService;

@RestController
public class FunController {

    private final FunService funService;

    public FunController(final FunService funService) {
        this.funService = funService;
    }

    @GetMapping
    public String getFun() {
        return funService.getRandomFact();
    }
}
