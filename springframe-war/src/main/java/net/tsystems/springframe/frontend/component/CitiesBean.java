package net.tsystems.springframe.frontend.component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

import net.tsystems.springframe.dao.CityEntityDao;
import net.tsystems.springframe.dao.impl.CityEntityDaoImpl;
import net.tsystems.springframe.services.objects.CityEntitySO;
import net.tsystems.springframe.services.services.CityService;
import net.tsystems.springframe.services.services.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean(name = "citiesBean")
@Component(value = "citiesBean")
public class CitiesBean implements Serializable {

    private CityService cityService = new CityServiceImpl();

    private CityEntitySO city;

    private HtmlInputText newName;

    public void setNewName(HtmlInputText newName){
        this.newName = newName;
    }

    public HtmlInputText getNewName(){
        return this.newName;
    }

    private static int editCityId;
    public void setEditCityId(int cityId){
        editCityId = cityId;
    }

    public List<CityEntitySO> getCity() {
        if (city == null) {
            int editId = editCityId;
            this.city = cityService.getCityById(editId);
            this.newName.setValue(this.city.getName());
        }
        ArrayList<CityEntitySO> result = new ArrayList<>();
                result.add(city);
        return result;
    }

    public void setCity(CityEntitySO city)
    {
        this.city = city;
    }

    public List getCities() {
        return cityService.getAllCities();
    }

    public String newCity()
    {
        //this.city = new CityEntitySO();
        return "addCity.xhtml?faces-redirect=true";
    }

    public String editCity()
    {
        //int editId = this.editCityId;
        //this.city = cityService.getCityById(editId);

        return "editCity?faces-redirect=true";
    }


    public String delete()
    {
        int editId = editCityId;
        CityEntitySO city = cityService.getCityById(editId);
        cityService.deleteCity(city);
        return "cities?faces-redirect=true";
    }
    public String update(String newValue)
    {
        this.city.setName(newValue);
        cityService.updateCity(city);
        return "cities?faces-redirect=true";
    }

    public String create(String newValue)
    {
        CityEntitySO city = new CityEntitySO();
        city.setName(newValue);
        cityService.addCity(city);
        return "cities?faces-redirect=true";
    }
}
