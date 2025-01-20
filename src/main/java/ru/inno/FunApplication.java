package ru.inno;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.inno.repositories.FunLocalRepo;

@SpringBootApplication
public class FunApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunApplication.class, args);
    }

    @Bean
    public MeterBinder meterBinder(FunLocalRepo repo) {
        return meterRegistry ->
                Gauge.builder("bread.size", repo::getRecordsCount)
                        .description("Number of bread records")
                        .tag("repo", repo.getClass().getSimpleName())
                        .register(meterRegistry);
    }
}
