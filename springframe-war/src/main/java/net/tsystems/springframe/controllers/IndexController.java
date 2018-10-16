package net.tsystems.springframe.controllers;

import net.tsystems.springframe.dao.CityEntityDao;
import net.tsystems.springframe.dao.impl.CityEntityDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class IndexController {

    @RequestMapping(value = { "/index", "/" })
    public String getIndex(){
        return "index";
    }

  /*  @RequestMapping(value = "/cities", method = RequestMethod.GET)
    public String listCities(Model model) {
        /*Session session = SessionService.getSession();
        Query query = session.createQuery("from CityEntity");
        //model.addAttribute("cityEntity", new CityEntity());
        List c = query.list();*/
  /*      CityEntityDao dao = new CityEntityDaoImpl();
        List c =  dao.getAllCities();
        model.addAttribute("listCities", c);
        return "cities";
    }*/

    @RequestMapping(value = { "/index.xhtml" }, method = { RequestMethod.GET })
    public ModelAndView listCities()
    {
        ModelAndView model = new ModelAndView();
        model.setViewName("cities");
        CityEntityDao dao = new CityEntityDaoImpl();
        List c =  dao.getAllCities();
        model.addObject("listCities", c);
        return model;
    }

}