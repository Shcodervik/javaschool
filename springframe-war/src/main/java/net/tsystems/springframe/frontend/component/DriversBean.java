package net.tsystems.springframe.frontend.component;

import net.tsystems.springframe.dao.DriverEntityDao;
import net.tsystems.springframe.dao.impl.DriverEntityDaoImpl;
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@ManagedBean(name = "driversBean")
@Component(value = "driversBean")
public class DriversBean implements Serializable {

    public List getDrivers() {
        DriverEntityDao dao = new DriverEntityDaoImpl();
        return dao.getAllDrivers();
    }
}
