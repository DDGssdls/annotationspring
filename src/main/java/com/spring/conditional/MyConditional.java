package com.spring.conditional;

import com.spring.entites.Person;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        BeanDefinitionRegistry registry = context.getRegistry();
        registry.containsBeanDefinition("person");



        return false;
    }
}
