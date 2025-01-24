package ru.inno.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile({"local"})
public class FunLocalRepo extends FunRepo {

    @Override
    public List<String> getList() {
        return List.of("local");
    }

}
