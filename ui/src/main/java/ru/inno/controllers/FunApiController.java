package ru.inno.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.FunService;
import ru.inno.exceptions.EntryNotExistsException;
import ru.inno.model.ErrorModel;
import ru.inno.model.FunFactModel;
import ru.inno.services.TestService;

@RestController
@RequestMapping("/api")
public class FunApiController {

    private final FunService funService;
    private final TestService testService;

    public FunApiController(final FunService funService, final TestService testService) {
        this.funService = funService;
        this.testService = testService;
    }

    @GetMapping("random")
    public FunFactModel getFun() {
        testService.doSomething();
        return funService.getRandomFact();
    }

    @ExceptionHandler(EntryNotExistsException.class)
    public ResponseEntity<ErrorModel> handleEntryNotExistsException(final EntryNotExistsException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorModel(e.getCode(), "Not found"));
    }
}
