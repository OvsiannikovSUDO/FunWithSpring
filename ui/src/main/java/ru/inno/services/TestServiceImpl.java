package ru.inno.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import ru.inno.aspects.PerfLogging;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Override
    @PerfLogging
    public void doSomething() {
        ((TestService) AopContext.currentProxy()).doSomethingElse();
    }

    @Override
    @PerfLogging
    public void doSomethingElse() {
        log.info("doSomethingElse");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
