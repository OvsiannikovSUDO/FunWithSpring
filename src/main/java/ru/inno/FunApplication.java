package ru.inno;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.inno.repositories.FunRepo;
import ru.inno.services.SandboxService;

@SpringBootApplication
public class FunApplication {

    public static void main(String[] args) {
        // SpringApplication.run(FunApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        SandboxService sandboxService = context.getBean(SandboxService.class);
        sandboxService.doSomething();
    }

    @Bean
    public MeterBinder meterBinder(FunRepo repo) {
        return meterRegistry ->
                Gauge.builder("bread.size", repo::getRecordsCount)
                        .description("Number of bread records")
                        .tag("repo", repo.getClass().getSimpleName())
                        .register(meterRegistry);
    }
}
