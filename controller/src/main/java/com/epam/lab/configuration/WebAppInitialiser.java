package com.epam.lab.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebAppInitialiser implements WebApplicationInitializer {

    private static final String SPRING_DISPATCHER = "SpringDispatcher";
    private static final String ENCODING_FILTER = "encodingFilter";
    private static final String ENCODING = "encoding";
    private static final String UTF_8 = "UTF-8";
    private static final String FORCE_ENCODING = "forceEncoding";
    private static final String TRUE = "true";
    private static final String SLASH = "/";

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(WebConfig.class);
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(SPRING_DISPATCHER, new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(SLASH);
        FilterRegistration.Dynamic fr = servletContext.addFilter(ENCODING_FILTER, CharacterEncodingFilter.class);
        fr.setInitParameter(ENCODING, UTF_8);
        fr.setInitParameter(FORCE_ENCODING, TRUE);
    }

}