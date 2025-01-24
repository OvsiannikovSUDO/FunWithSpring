package ru.inno.services;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import ru.inno.config.CustomCondition;
import ru.inno.controllers.model.FunFactModel;
import ru.inno.repositories.FunRepo;

import java.util.concurrent.ThreadLocalRandom;

@Service
@Conditional(CustomCondition.class)
public class FunService {

    private final FunRepo repo;

    public FunService(final FunRepo repo) {
        this.repo = repo;
    }

    public String getServiceName() {
        return "Fun Service";
    }

    public FunFactModel getRandomFact() {
        final var list = repo.getList();
        final String fact = list.get(ThreadLocalRandom.current().nextInt(list.size()));
        return new FunFactModel(1, fact);
    }
}
