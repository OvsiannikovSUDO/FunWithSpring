package ru.inno.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

// always true
public class CustomCondition implements Condition {
    @Override
    public boolean matches(final ConditionContext context, final AnnotatedTypeMetadata metadata) {
        return true;
    }
}
