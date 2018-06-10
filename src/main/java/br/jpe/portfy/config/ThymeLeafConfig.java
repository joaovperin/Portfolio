/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.config;

import br.jpe.portfy.thymeleaf.TagsDialect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
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

    /** Views folder */
    private static final String VIEWS = "WEB-INF/views/";
    /** Views suffix */
    private static final String VIEW_SUFF = ".html";

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
        engine.addDialect(new TagsDialect());
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

}
