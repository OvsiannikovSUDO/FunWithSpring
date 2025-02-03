package ru.inno.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SandboxServiceTest {

    @Autowired
    @Qualifier("sandboxServiceA")
    private SandboxService serviceC;

    @Autowired
    private SandboxService serviceB;

    @Test
    void checkInit() {
        assertNotNull(serviceC);
        assertNotNull(serviceB);

        serviceC.doSomething();
        serviceB.doSomething();
    }

    @Test
    void checkPrototype() {
        final var id1 = serviceB.doSomething();
        final var id2 = serviceB.doSomething();
        assertNotEquals(id1, id2);
    }
}