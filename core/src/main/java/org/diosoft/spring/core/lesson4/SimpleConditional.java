package org.diosoft.spring.core.lesson4;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by yar on 06.03.15.
 */
public class SimpleConditional implements ConfigurationCondition{
    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.REGISTER_BEAN;
    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return Boolean.valueOf(conditionContext.getEnvironment().getProperty("bean.simple"));
    }
}
