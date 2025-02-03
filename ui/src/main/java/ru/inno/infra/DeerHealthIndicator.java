package ru.inno.infra;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class DeerHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        final var healthBuilder = ThreadLocalRandom.current().nextInt(10) > 6 ?
                Health.down() :
                Health.up();
        return healthBuilder
                .withDetail("name", "Bamby")
                .build();
    }
}
