package com.sanchit.Restfull_2.service;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class SayHelloService {

    private MessageSource messageSource;

    public SayHelloService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getHello() {
        Locale locale = LocaleContextHolder.getLocale();
        String greeting = messageSource.getMessage("greeting", null, locale);
        return greeting;
    }

}
