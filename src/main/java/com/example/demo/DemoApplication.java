package com.example.demo;

import com.example.demo.servlet.SimpleStatusServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * Requirement: STEP 7 - Servlet Registration
     * Registers the HttpServlet to handle requests at /simple-status
     */
    @Bean
    public ServletRegistrationBean<SimpleStatusServlet> statusServletRegistration() {
        ServletRegistrationBean<SimpleStatusServlet> registrationBean = 
            new ServletRegistrationBean<>(new SimpleStatusServlet(), "/simple-status");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }
}