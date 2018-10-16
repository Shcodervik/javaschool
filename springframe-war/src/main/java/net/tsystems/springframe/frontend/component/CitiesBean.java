package net.tsystems.springframe.frontend.component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import net.tsystems.springframe.dao.CityEntityDao;
import net.tsystems.springframe.dao.impl.CityEntityDaoImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@ViewScoped
@ManagedBean(name = "citiesBean")
@Component(value = "citiesBean")
public class CitiesBean {

    public List getCities() {
        CityEntityDao dao = new CityEntityDaoImpl();
        //FacesContext.getCurrentInstance().
        return dao.getAllCities();
    }

}
