package ru.inno.services;

import ru.inno.repositories.FunRepo;

public class FunServiceWithDep extends FunService {

    public FunServiceWithDep(final FunRepo repo) {
        super(repo);
    }

    @Override
    public String getServiceName() {
        return "Fun Service with Dep";
    }
}
