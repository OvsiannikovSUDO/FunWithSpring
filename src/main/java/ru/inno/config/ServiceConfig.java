package ru.inno.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.inno.repositories.FunRepo;
import ru.inno.services.FunService;
import ru.inno.services.FunServiceWithDep;

@Configuration
public class ServiceConfig {

    @Bean
    @ConditionalOnMissingClass("ru.inno.services.FunServiceWithDep")
    public FunService getFunService(final FunRepo repo) {
        return new FunService(repo);
    }

    @Bean
    @ConditionalOnClass(FunServiceWithDep.class)
    public FunService getFunServiceWithDep(final FunRepo repo) {
        return new FunServiceWithDep(repo);
    }
}
