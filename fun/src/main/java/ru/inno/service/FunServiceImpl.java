package ru.inno.service;

import org.springframework.stereotype.Service;
import ru.inno.FunService;
import ru.inno.model.FunFactModel;
import ru.inno.repo.FunRepo;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FunServiceImpl implements FunService {

    private final FunRepo repo;

    public FunServiceImpl(final FunRepo repo) {
        this.repo = repo;
    }

    public String getServiceName() {
        return "Fun Service";
    }

    @Override
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
        return new FunFactModel(repo.updateRecord(/*fact.id()*/ 1, fact.joke()));
    }
}
