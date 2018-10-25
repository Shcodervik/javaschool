package net.tsystems.springframe.frontend.component;

import net.tsystems.springframe.dao.DriverEntityDao;
import net.tsystems.springframe.dao.impl.DriverEntityDaoImpl;
import net.tsystems.springframe.services.objects.DriverEntitySO;
import net.tsystems.springframe.services.services.DriverService;
import net.tsystems.springframe.services.services.impl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.persistence.Converter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Been for drivers.
 *
 * @author shcodervik
 *
 */
@SessionScoped
@ManagedBean(name = "driversBean")
@Component(value = "driversBean")
public class DriversBean implements Serializable {

    @Autowired
    @Qualifier("driverService")
    DriverService driverService;

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

    public Set<DriverEntitySO> getDriver() {
        if (driver == null) {
            int editId = editDriverId;
            this.driver = driverService.getDriverById(editId);
            this.newName.setValue(this.driver.getName());
        }
        HashSet<DriverEntitySO> result = new HashSet<>();
        result.add(driver);
        return result;
    }
    public List<DriverEntitySO> getDrivers() {
        return driverService.getAllDrivers();
    }

    public String newDriver()
    {
        clearItems();
        return "addDriver.xhtml?faces-redirect=true";
    }

    public String editDriver()
    {
        clearItems();
        int editId = this.editDriverId;
        this.driver = driverService.getDriverById(editId);

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
        this.driver = null;
        DriverEntitySO driver = new DriverEntitySO();
        driver.setName(newValueName);
        driver.setSurname(newValueSurname);
        driver.setUIN(newValueUIN);
        driverService.addDriver(driver);
        return "drivers?faces-redirect=true";
    }

    @Autowired
    public void setDriverService(DriverService driverService) {
        this.driverService = driverService;
    }

    public void clearItems(){
        this.driver = null;
        this.newName = null;
        this.newSurname = null;
        this.newValueUIN = null;
    }
}
