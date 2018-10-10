package net.tsystems.springframe.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author storgovt
 */
public class ApplicationInitializer  implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();

        annotationConfigWebApplicationContext.setServletContext(servletContext);
        annotationConfigWebApplicationContext.scan("net.tsystems.springframe.configuration");

        servletContext.addListener(new ContextLoaderListener(annotationConfigWebApplicationContext));
        servletContext.addListener(new RequestContextListener());

        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(annotationConfigWebApplicationContext));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(NumberUtils.INTEGER_ONE);
//
//        ServletRegistration.Dynamic faces = servletContext.addServlet("faces", new DispatcherServlet(annotationConfigWebApplicationContext));
//        faces.addMapping("/pages/*");
//        faces.addMapping("*.faces");
//        faces.addMapping("*.jsf");
//        faces.addMapping("*.xhtml");
//        faces.addMapping("/*");
//        faces.setLoadOnStartup(NumberUtils.INTEGER_ONE);





    }

   /* @Bean
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver   viewResolver = new InternalResourceViewResolver ();
        //viewResolver.setPrefix("/pages/");
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".xhtml");
        return viewResolver;
    }*/
/*
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }
*/

}
