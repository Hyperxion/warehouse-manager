package com.edemko.warehousemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

public class WarehouseManagerConfig {

    @Autowired
    //We make this private just so that nothing else in the package utilizes it because we want autowire and inject that
    //wherever we're going to use it
    private ApplicationContext applicationContext;

    /*
    This is an example of what is being done behind scenes by @SpringBootApplication in you conference appplication.
    With suffix and prefix set up here, we can comment them out in application.properties file
     */
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setPrefix("/WEB-INF/jsp/");
//        bean.setSuffix(".jsp");
//        //in case of multiple view resolvers, we can set order of execution and first to be successfully executed will be applied
//        //for thymeleaf example we set this to 1
//        bean.setOrder(1);
//
//        return bean;
//    }

    @Bean
    public ViewResolver thymeleafResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        //order has to be 0 to lad first. Also order for JSP resolver has to be 1
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
