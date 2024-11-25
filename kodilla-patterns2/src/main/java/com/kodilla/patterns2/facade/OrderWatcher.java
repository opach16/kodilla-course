package com.kodilla.patterns2.facade;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class OrderWatcher {

    private static final Logger LOGGER = Logger.getLogger(OrderWatcher.class.getName());

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEvent() {
        LOGGER.info("Order process begin");
    }

    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEventEnd() {
        LOGGER.info("Order process ended");
    }
}
