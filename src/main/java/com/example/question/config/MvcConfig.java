package com.example.question.config;

import com.example.question.util.RedirectInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

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
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RedirectInterceptor());
    }
}
