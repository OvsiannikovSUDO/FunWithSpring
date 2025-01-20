package ru.inno.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
@Profile({"local"})
@Primary
public class FunLocalRepo extends FunRepo {

    @Override
    public List<String> getList() {
        return List.of("local");
    }

    public int getRecordsCount() {
        return ThreadLocalRandom.current().nextInt();
    }
}
