/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jpe.portfy.config;

import br.jpe.portfy.thymeleaf.TagsDialect;
import java.nio.charset.StandardCharsets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
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
public class ThymeLeafConfig {

    /** Views folder */
    private static final String VIEWS = "WEB-INF/views/";
    /** Views suffix */
    private static final String VIEW_SUFF = ".html";

    /**
     * Creates and return the View Resolver for Spring
     *
     * @return ViewResolver
     */
    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        return thymeleafViewResolver;
    }

    /**
     * Creates and return the Template Engine for Thymeleaf
     *
     * @return ISpringTemplateEngine
     */
    @Bean
    public ISpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addTemplateResolver(new UrlTemplateResolver());
        engine.addTemplateResolver(templateResolver());
        engine.addDialect(new TagsDialect());
        engine.addDialect(new Java8TimeDialect());
        return engine;
    }

    /**
     * Creates and return the Template Resolver for Thymeleaf
     *
     * @return ITemplateResolver
     */
    @Bean
    public ITemplateResolver templateResolver() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix(VIEWS);
        resolver.setSuffix(VIEW_SUFF);
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resolver.setCacheable(false);
        return resolver;
    }

}
