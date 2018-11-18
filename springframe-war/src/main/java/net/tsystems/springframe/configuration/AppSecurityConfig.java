/*
 * Copyright (c) 2018.
 */

package net.tsystems.springframe.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Configuration
//@EnableWebMvcSecurity
public class AppSecurityConfig { //extends WebSecurityConfigurerAdapter {

//    @Autowired
//    @Qualifier("customUserDetailsService")
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    AuthenticationSuccessHandler authenticationSuccessHandler;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
//    {
//
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(getShaPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.userDetailsService(userDetailsService).passwordEncoder(new ShaPasswordEncoder(512));
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//
//        http.csrf().disable()
//
//                .authorizeRequests()
//
//                .antMatchers("/admincp/**").hasAnyRole("ADMINISTRATOR", "SUPERADMINISTRATOR")
//
//                .antMatchers("/workspace/**").hasAnyRole("SUPERADMINISTRATOR", "ADMINISTRATOR", "USER")
//
//                .antMatchers("/login**","/css/**", "/js/**", "/images/**", "/**/favicon.ico", "/error").permitAll()
//
//                .and()
//
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login.xhtml")
//                .failureUrl("/login.xhtml?error")
//                .defaultSuccessUrl("/index.xhtml", true)
//                .successHandler(authenticationSuccessHandler)
//
//                .and()
//
//                .logout().invalidateHttpSession(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//
//                .and()
//
//                .httpBasic();
//
//
//
//    }
//
//
//    @Bean
//    public ShaPasswordEncoder getShaPasswordEncoder(){
//        return new ShaPasswordEncoder();
//    }

}
