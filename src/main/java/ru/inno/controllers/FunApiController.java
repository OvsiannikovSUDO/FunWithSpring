package ru.inno.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inno.controllers.model.ErrorModel;
import ru.inno.controllers.model.FactRequest;
import ru.inno.controllers.model.FunFactModel;
import ru.inno.exceptions.EntryNotExistsException;
import ru.inno.services.FunService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FunApiController {

    private final FunService funService;

    public FunApiController(final FunService funService) {
        this.funService = funService;
    }

    @GetMapping("random")
    public FunFactModel getFun() {
        return funService.getRandomFact();
    }

    @GetMapping("fact")
    public List<FunFactModel> getFactsList() {
        return funService.getAllFacts();
    }

    @PostMapping("fact")
    public FunFactModel create(@RequestBody @Valid final FactRequest request) {
        return funService.createFact(request.text());
    }

    @PutMapping("fact/{id}")
    public FunFactModel update(@PathVariable final long id,
                               @RequestBody @Valid final FactRequest request) {
        return funService.updateFact(new FunFactModel(id, request.text()));
    }

    @ExceptionHandler(EntryNotExistsException.class)
    public ResponseEntity<ErrorModel> handleEntryNotExistsException(final EntryNotExistsException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorModel(e.getCode(), "Not found"));
    }
}
