package ru.inno.services;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SandboxServiceA implements SandboxService, InitializingBean, BeanNameAware, ApplicationContextAware {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SandboxServiceA.class);

    public SandboxServiceA() {
        log.info("SandboxServiceA constructor");
    }

    @Override
    public int doSomething() {
        log.info("SandboxServiceA - do something");
        return 0;
    }

    @PostConstruct
    public void init() {
        log.info("SandboxServiceA init");
    }

    @Override
    public void setBeanName(final String name) {
        log.info("SandboxServiceA setBeanName: {}", name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("SandboxServiceA afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        log.info("SandboxServiceA setApplicationContext");
    }
}
