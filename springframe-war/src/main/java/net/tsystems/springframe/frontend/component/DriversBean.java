package net.tsystems.springframe.frontend.component;

import net.tsystems.springframe.dao.DriverEntityDao;
import net.tsystems.springframe.dao.impl.DriverEntityDaoImpl;
import net.tsystems.springframe.services.objects.DriverEntitySO;
import net.tsystems.springframe.services.services.DriverService;
import net.tsystems.springframe.services.services.impl.DriverServiceImpl;
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.persistence.Converter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ViewScoped
@ManagedBean(name = "driversBean")
@Component(value = "driversBean")
public class DriversBean implements Serializable {

    private DriverService driverService = new DriverServiceImpl();

    DriverEntitySO driver;

    private HtmlInputText newName;
    private HtmlInputText newSurname;
    private HtmlInputText newValueUIN;

    private static int editDriverId;
    public void setEditDriverId(int driverId){
        editDriverId = driverId;
    }


    public HtmlInputText getNewName() {
        return newName;
    }

    public void setNewName(HtmlInputText newName) {
        this.newName = newName;
    }

    public HtmlInputText getNewSurname() {
        return newSurname;
    }

    public void setNewSurname(HtmlInputText newSurname) {
        this.newSurname = newSurname;
    }

    public HtmlInputText getNewValueUIN() {
        return newValueUIN;
    }

    public void setNewValueUIN(HtmlInputText newValueUIN) {
        this.newValueUIN = newValueUIN;
    }
    public void setDriver(DriverEntitySO driver)
    {
        this.driver = driver;
    }

    public List<DriverEntitySO> getDriver() {
        if (driver == null) {
            int editId = editDriverId;
            this.driver = driverService.getDriverById(editId);
            this.newName.setValue(this.driver.getName());
        }
        ArrayList<DriverEntitySO> result = new ArrayList<>();
        result.add(driver);
        return result;
    }
    public List getDrivers() {
        return driverService.getAllDrivers();
    }

    public String newDriver()
    {
        return "addDriver.xhtml?faces-redirect=true";
    }

    public String editDriver()
    {
        //int editId = this.editCityId;
        //this.city = cityService.getCityById(editId);

        return "editDriver?faces-redirect=true";
    }


    public String delete()
    {
        int editId = editDriverId;
        DriverEntitySO driver = driverService.getDriverById(editId);
        driverService.deleteDriver(driver);
        return "drivers?faces-redirect=true";
    }
    public String update(String newValueUIN, String newValueName, String newValueSurname)
    {
        this.driver.setName(newValueName);
        this.driver.setSurname(newValueSurname);
        this.driver.setUIN(newValueUIN);
        driverService.updateDriver(driver);
        return "drivers?faces-redirect=true";
    }

    public String create(String newValueUIN, String newValueName, String newValueSurname)
    {
        DriverEntitySO driver = new DriverEntitySO();
        driver.setName(newValueName);
        driver.setSurname(newValueSurname);
        driver.setUIN(newValueUIN);
        driverService.addDriver(driver);
        return "drivers?faces-redirect=true";
    }

}
