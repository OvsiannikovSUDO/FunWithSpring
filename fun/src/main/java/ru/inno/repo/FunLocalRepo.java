package ru.inno.repo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"local"})
public class FunLocalRepo extends FunRepo {

}
