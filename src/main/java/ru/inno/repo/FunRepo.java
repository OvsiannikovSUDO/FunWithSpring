package ru.inno.repo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FunRepo {

    public List<String> getList() {
        return List.of("Fun fact1", "Fact3333");
    }
}
