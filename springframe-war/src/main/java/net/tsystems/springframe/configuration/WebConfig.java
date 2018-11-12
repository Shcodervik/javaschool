package net.tsystems.springframe.configuration;

import net.tsystems.springframe.configuration.auth.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * @author shcodervik
 */
@EnableWebMvc
@Configuration
@ComponentScan({"net.tsystems.springframe"})
public class WebConfig {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver result = new InternalResourceViewResolver();
        result.setViewClass(JstlView.class);
        result.setPrefix("/");
        result.setSuffix(".xhtml");

        return result;
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new CustomUserDetailsService();
    }






}
