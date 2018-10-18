package net.tsystems.springframe.frontend.component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import net.tsystems.springframe.dao.CityEntityDao;
import net.tsystems.springframe.dao.impl.CityEntityDaoImpl;
import net.tsystems.springframe.services.objects.CityEntitySO;
import net.tsystems.springframe.services.services.CityService;
import net.tsystems.springframe.services.services.impl.CityServiceImpl;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@SessionScoped
@ManagedBean(name = "citiesBean")
@Component(value = "citiesBean")
public class CitiesBean implements Serializable {
    private CityService service = new CityServiceImpl();

    public List getCities() {
        //CityEntityDao dao = new CityEntityDaoImpl();
        //FacesContext.getCurrentInstance().

        return service.getAllCities();
    }

}
