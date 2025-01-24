package ru.inno.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
@Profile({"!local"})
public class FunRepo {

    public List<String> getList() {
        return List.of("Fun fact1", "Fact3333");
    }

    public int getRecordsCount() {
        return ThreadLocalRandom.current().nextInt();
    }
}
