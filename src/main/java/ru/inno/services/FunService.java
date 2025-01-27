package ru.inno.services;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import ru.inno.config.CustomCondition;
import ru.inno.controllers.model.FunFactModel;
import ru.inno.repositories.FunRepo;

import java.util.List;
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

        final var fact = list.entrySet().stream().toList().get(ThreadLocalRandom.current().nextInt(list.size()));
        return new FunFactModel(fact);
    }

    public List<FunFactModel> getAllFacts() {
        return repo.getList()
                .entrySet()
                .stream()
                .map(FunFactModel::new)
                .toList();
    }

    public FunFactModel createFact(final String fact) {
        return new FunFactModel(repo.createRecord(fact));
    }

    public FunFactModel updateFact(final FunFactModel fact) {
        return new FunFactModel(repo.updateRecord(fact.id(), fact.fact()));
    }
}
