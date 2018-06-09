/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

/**
 * Thymeleaf Configuration Class
 *
 * @author joaovperin
 */
@Configuration
public class ThymeLeafConfig implements ApplicationContextAware {

    /** Internalization (i18n) messages */
    private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";
    /** Views folder */
    private static final String VIEWS = "WEB-INF/views/";
    /** Views suffix */
    private static final String VIEW_SUFF = ".html";
    /** Resources location */
    private static final String RESOURCES_LOCATION = "/resources/";
    /** Resources handler */
    private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";

    /** Application context */
    private ApplicationContext applicationContext;

    /**
     * Setter for the application context
     *
     * @param applicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        return thymeleafViewResolver;
    }

    @Bean
    public ITemplateResolver templateResolver() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix(VIEWS);
        resolver.setSuffix(VIEW_SUFF);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);
        return resolver;
    }

    @Bean
    public ISpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addTemplateResolver(new UrlTemplateResolver());
        engine.addTemplateResolver(templateResolver());
        engine.addTemplateResolver(springTemplateResolver());
        engine.addDialect(new Java8TimeDialect());
        return engine;
    }

    @Bean
    public ITemplateResolver springTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    /**
     * A static class to configure MVC
     */
    static class WebMvcConfig extends WebMvcConfigurationSupport {

        @Override
        public RequestMappingHandlerMapping requestMappingHandlerMapping() {
            RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
            requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
            requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
            return requestMappingHandlerMapping;
        }

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
        }

        @Override
        public Validator getValidator() {
            LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
            validator.setValidationMessageSource(messageSource());
            return validator;
        }

        private MessageSource messageSource() {
            ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
            messageSource.setBasename(MESSAGE_SOURCE);
            messageSource.setCacheSeconds(5);
            return messageSource;
        }

    }

    /**
     * Handles favicon.ico requests and returns that
     */
    @Controller
    static class FaviconController {

        @RequestMapping("favicon.ico")
        String favicon() {
            return "forward:/resources/static/favicon.ico";
        }
    }
}
