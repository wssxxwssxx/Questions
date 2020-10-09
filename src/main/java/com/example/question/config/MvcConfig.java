package com.example.question.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"com.example.question.controller"})
public class MvcConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/newform").setViewName("newform");
        registry.addViewController("/authorized").setViewName("authorized");
        registry.addViewController("/registration").setViewName("registration");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/form").setViewName("form");
        registry.addViewController("/topic").setViewName("topic");
        registry.addViewController("/cabinet").setViewName("cabinet");
        registry.addViewController("/ch_login").setViewName("ch_login");
        registry.addViewController("/ch_chat").setViewName("ch_chat");
        registry.addViewController("/answers/**").setViewName("answers/**");
        registry.addViewController("/results").setViewName("results");
        registry.addViewController("/chat").setViewName("chat");
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/resources/templates");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    //    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new RedirectInterceptor());
//    }
}
