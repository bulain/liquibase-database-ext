package com.bulain.flowable;

import org.flowable.common.engine.impl.util.ReflectUtil;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 *
 */
@Configuration
@ConditionalOnClass({SpringProcessEngineConfiguration.class})
public class FlowableSpeBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SpringProcessEngineConfiguration) {
            Properties databaseTypeMappings = SpringProcessEngineConfiguration.getDefaultDatabaseTypeMappings();
            databaseTypeMappings.setProperty("DM DBMS", "oracle");
            databaseTypeMappings.setProperty("KingbaseES", "postgres");

            Field field = ReflectUtil.getField("databaseTypeMappings", bean);
            ReflectUtil.setField(field, bean, databaseTypeMappings);
        }
        return bean;
    }

}
