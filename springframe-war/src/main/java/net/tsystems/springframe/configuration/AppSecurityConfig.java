/*
 * Copyright (c) 2018.
 */

package net.tsystems.springframe.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;


    @Autowired
    AuthenticationSuccessHandler authenticationSuccessHandler;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        //auth.userDetailsService(userDetailsService).passwordEncoder(shaPasswordEncoder());
        auth.inMemoryAuthentication().withUser("1234").password("qwerty").roles("ADMINISTRATOR");
        //"3c7ed30f4087a377298da34e2da9237b819ccaa68118c6a1945937e535fe2ddbf70faa6ac45593fc1aa8b6f72c2c878b7ddc65feb21607f91023ba5f71295228"
    }

    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception
    //{
        //auth.userDetailsService(userDetailsService).passwordEncoder(shaPasswordEncoder());


    //}

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {

        http.csrf().disable()

                .authorizeRequests()

                .antMatchers("/login**","/css/**", "/js/**", "/images/**", "/**/favicon.ico", "/error").permitAll()
                .antMatchers("/workspace/**").hasAnyRole("USER")
                .antMatchers("/admincp/**").hasAnyRole("ADMINISTRATOR")
                .anyRequest().authenticated()





                .and()

                .formLogin()
                //.loginPage("/login")
                //.loginProcessingUrl("/login")
                //.failureUrl("/login?error=true")
                //.defaultSuccessUrl("/", true)
                //.successHandler(authenticationSuccessHandler)

                .and()

                .logout().invalidateHttpSession(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                .and()

                .httpBasic();


    }

@Bean
    public ShaPasswordEncoder shaPasswordEncoder(){
        return new ShaPasswordEncoder(512);
}


}
