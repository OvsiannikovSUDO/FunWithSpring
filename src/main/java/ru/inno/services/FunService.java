package ru.inno.services;

import org.springframework.stereotype.Service;
import ru.inno.api.model.FunFactModel;
import ru.inno.repo.FunRepo;

import java.util.Random;

@Service
public class FunService {

    private final FunRepo repo;

    public FunService(final FunRepo repo) {
        this.repo = repo;
    }

    public FunFactModel getRandomFact() {
        final var list = repo.getList();
        final String fact = list.get(new Random().nextInt(list.size()));
        return new FunFactModel(1, fact);
    }
}
