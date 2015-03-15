package org.diosoft.spring.core.hw4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.sql.Array;
import java.util.Arrays;

/**
 * Created by yar on 12.03.15.
 */
public class ConditionalObserver implements ConfigurationCondition {
    @Override
    public ConfigurationPhase getConfigurationPhase() {
        return ConfigurationPhase.REGISTER_BEAN;
    }

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (conditionContext.getEnvironment() != null) {
            MultiValueMap<String, Object> attrs = annotatedTypeMetadata.getAllAnnotationAttributes(Bean.class.getName());
            if (attrs != null) {
                String type = ((String[])attrs.get("name").get(0))[0];
                return Boolean.valueOf(conditionContext.getEnvironment().getProperty("bean.observer."+type));
            }
        }
        return false;
    }
}
