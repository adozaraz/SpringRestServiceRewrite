package org.springRetry.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextHolder implements ApplicationContextAware {
    private static ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class, SpringConfig.class);

    public static ApplicationContext getApplicationContext() {
        return context;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}