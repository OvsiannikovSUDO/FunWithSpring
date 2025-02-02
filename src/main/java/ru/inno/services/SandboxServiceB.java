package ru.inno.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("serviceB")
public class SandboxServiceB implements SandboxService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SandboxServiceB.class);

    private final ApplicationContext applicationContext;
    private final ObjectFactory<UserSession> userSessionFactory;
    private final ObjectFactory<SandboxServiceA> serviceAFactory;

    public SandboxServiceB(
            final ObjectFactory<UserSession> userSessionFactory,
            final ApplicationContext applicationContext,
            final ObjectFactory<SandboxServiceA> serviceAFactory
    ) {
        this.applicationContext = applicationContext;
        this.userSessionFactory = userSessionFactory;
        this.serviceAFactory = serviceAFactory;
    }

    @Override
    public int doSomething() {
        // final var userSession = applicationContext.getBean("userSession", UserSession.class);
        // final var userSession = userSessionFactory.getObject();
        final var userSession = getUserSession();
        final var sandboxServiceA = serviceAFactory.getObject();
        sandboxServiceA.doSomething();
        log.info("SandboxServiceB - do something, id={}", userSession.getId());

        return userSession.getId();
    }

    @Lookup
    public UserSession getUserSession() {
        return null;
    }
}
