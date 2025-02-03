package ru.inno.services;

import org.springframework.web.service.annotation.GetExchange;
import ru.inno.model.FunFactModel;

public interface FunServiceClient extends ru.inno.FunService {

    @GetExchange
    FunFactModel getRandomFact();
}
