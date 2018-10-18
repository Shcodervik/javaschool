package net.tsystems.springframe.controllers;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {

    @RequestMapping(value = { "/index", "/" })
    public String getIndex(){
        return "index";
    }


}