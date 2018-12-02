/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.frontend.component;

import net.tsystems.springframe.services.Utils;
import net.tsystems.springframe.services.objects.UserEntitySO;
import net.tsystems.springframe.services.services.UserService;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

import org.primefaces.context.RequestContext;


@SessionScoped
@ManagedBean(name = "userLoginBean")
@Component(value = "userLoginBean")
public class UserLoginBean implements Serializable {

    private final String STRING_FEEDBACK_GENERAL_ERROR      = "Something went wrong";
    private final String STRING_FEEDBACK_LOGGED_IN          = "Logged in";

    private final String STRING_FEEDBACK_NO_SUCH_USER       = "No such user";

    private final String STRING_FEEDBACK_INCORRECT_USERNAME = "Incorrect password";


    //@ManagedProperty(value="#{authenticationManager}")
    //@ManagedBean(name = "authenticationManager")
    //private AuthenticationManager authenticationManager;
    //public AuthenticationManager getAuthenticationManager() {
    //    return authenticationManager;
    //}

    //@Autowired
    //public void setAuthenticationManager(AuthenticationManager authenticationManager) {
    //    this.authenticationManager= authenticationManager;
    //}

    private ShaPasswordEncoder encoder;
    @Autowired
    public void setEncoder(ShaPasswordEncoder encoder){
        this.encoder = encoder;
    }

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    UserEntitySO user;

    private String username;
    private String password;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String login()
    {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        UserEntitySO user = userService.getUserByUsername(username);
        String passH = encoder.encodePassword(password,username);
        //try {
            //SecurityContextHolder.getContext().setAuthentication(null);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        if (user != null){
            if (encoder.isPasswordValid(user.getPassHash(),password,username)){
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, STRING_FEEDBACK_LOGGED_IN, username.toString());
                context.addCallbackParam("loggedIn", true);
                FacesContext.getCurrentInstance().addMessage(null, message);
                return "/login?logout";
            }
            else {
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, STRING_FEEDBACK_GENERAL_ERROR,
                        STRING_FEEDBACK_INCORRECT_USERNAME);
            }
        }
        else {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, STRING_FEEDBACK_GENERAL_ERROR, STRING_FEEDBACK_NO_SUCH_USER);
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        return null;
    }

   /* public void logout(){
        SecurityContextHolder.getContext().setAuthentication(null);
    }*/


}
