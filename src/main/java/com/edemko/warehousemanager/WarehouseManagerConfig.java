package com.edemko.warehousemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

public class WarehouseManagerConfig {

    @Autowired
    //We make this private just so that nothing else in the package utilizes it because we want autowire and inject that
    //wherever we're going to use it
    private ApplicationContext applicationContext;

    @Bean
    public ViewResolver thymeleafResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        //order has to be 0 to load first. Also order for JSP resolver has to be 1 do they are not in confilct
        viewResolver.setOrder(0);

        return viewResolver;
    }

    //Here we add template resolver for thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    /*
    We didn't have to create an engine of any sort when dealing with JSP pages. This is unique for thymeleaf.
    We have to create a Spring template Engine that will process the pages and substitute in the model values
    from Spring into our pages to be displayed.
     */
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        //Allows us using spring Expression Language for shorthand syntax of accessing Spring variables and passing then in
        templateEngine.setEnableSpringELCompiler(true);

        return templateEngine;
    }

}
