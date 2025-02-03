package ru.inno.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.FunService;
import ru.inno.model.FunFactModel;

@RestController
@RequestMapping("api")
public class ApiController {

    private final FunService service;

    public ApiController(final FunService service) {
        this.service = service;
    }

    @GetMapping
    public FunFactModel getRandomFact() {
        return service.getRandomFact();
    }
}
