package ru.inno;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import ru.inno.repo.FunRepo;
import ru.inno.services.FunServiceClient;

@SpringBootApplication
public class FunApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunApplication.class, args);
    }

    @Bean
    public MeterBinder meterBinder(FunRepo repo) {
        return meterRegistry ->
                Gauge.builder("bread.size", repo::getRecordsCount)
                        .description("Number of bread records")
                        .tag("repo", repo.getClass().getSimpleName())
                        .register(meterRegistry);
    }

    @Bean
    public FunService githubClient() {
        RestClient restClient = RestClient.builder()
                //.baseUrl("http://localhost:8081/api")
                .baseUrl("https://icanhazdadjoke.com/")
                .defaultHeader("Accept", "application/json")
                .build();
        RestClientAdapter adapter = RestClientAdapter.create(restClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        return factory.createClient(FunServiceClient.class);
    }

}
