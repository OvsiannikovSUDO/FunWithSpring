package ru.inno.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@Slf4j
public class UserSession {

    private final int id;

    public UserSession() {
        this.id = ThreadLocalRandom.current().nextInt(1000);
        log.info("UserSession created, id: {}", id);
    }

    public int getId() {
        return id;
    }
}
