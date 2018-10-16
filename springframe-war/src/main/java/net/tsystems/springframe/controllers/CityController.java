package net.tsystems.springframe.controllers;


import net.tsystems.springframe.SessionService;
import net.tsystems.springframe.dao.CityEntityDao;
import net.tsystems.springframe.dao.impl.CityEntityDaoImpl;
import net.tsystems.springframe.services.objects.CityEntitySO;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@Controller
public class CityController {
    //private CityEntitySO cityEntitySO;

   /* @Autowired(required=true)
    @Qualifier(value="cityEntitySO")
    public void setPersonService(CityEntitySO ps){
        this.cityEntitySO = ps;
    }*/

 /*   @RequestMapping(value = "/cities", method = RequestMethod.GET)
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

    //For add and update person both
    /*@RequestMapping(value= "/city/add", method = RequestMethod.POST)
    public String addCity(@ModelAttribute("city") CityEntity cityEntity){

        if(cityEntity.getIdCity() == 0){
            //new city, add it
            this.cityEntitySO.(cityEntity);
        }else{
            //existing person, call update
            this.personService.updatePerson(cityEntity);
        }

        return "redirect:/persons";

    }*/
}
