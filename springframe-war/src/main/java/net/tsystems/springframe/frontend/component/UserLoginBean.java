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
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    UserEntitySO user;

    private HtmlInputText username;
    private HtmlInputText password;

    public HtmlInputText getUsername()
    {
        return username;
    }

    public void setUsername(HtmlInputText username)
    {
        this.username = username;
    }

    public HtmlInputText getPassword()
    {
        return password;
    }

    public void setPassword(HtmlInputText password)
    {
        this.password = password;
    }

    public void login(ActionEvent event)
    {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        UserEntitySO user = userService.getUserByUsername(username.toString());
        if (user != null){
            if (user.getPassHash().equals(password)){
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, STRING_FEEDBACK_LOGGED_IN, username.toString());
                    context.addCallbackParam("loggedIn", true);
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

    }


}
