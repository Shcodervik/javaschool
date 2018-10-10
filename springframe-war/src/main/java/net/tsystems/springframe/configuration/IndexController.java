package net.tsystems.springframe.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@Controller
public class IndexController {
  //  int visitorCount = 0;
//    @RequestMapping(method = RequestMethod.GET, value = "index")
//    public String index() {
//       // model.addAttribute("visitorCount", visitorCount++);
//        return "index";
//    }



   /* @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView secondPage(ModelAndView modelAndView) {
        modelAndView.setViewName("/pages/home");
        //modelAndView.setViewName("index");
        return modelAndView;
    }*/

}