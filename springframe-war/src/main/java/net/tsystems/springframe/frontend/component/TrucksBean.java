package net.tsystems.springframe.frontend.component;


import net.tsystems.springframe.services.objects.TruckEntitySO;
import net.tsystems.springframe.services.objects.TruckstateEntitySO;
import net.tsystems.springframe.services.services.TruckService;
import net.tsystems.springframe.services.services.TruckstateService;
import net.tsystems.springframe.services.services.impl.TruckServiceImpl;
import net.tsystems.springframe.services.services.impl.TruckstateServiceImpl;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ViewScoped
@ManagedBean(name = "trucksBean")
@Component(value = "trucksBean")
public class TrucksBean implements Serializable {

    private TruckService truckService = new TruckServiceImpl();
    private TruckstateService truckStateService = new TruckstateServiceImpl();

    TruckEntitySO truck;
    TruckstateEntitySO truckState;

    private HtmlInputText newSerial;
    private HtmlInputText newCapacity;
    private HtmlInputText newDriversNumber;
    private HtmlSelectOneMenu newTruckState;
    private String truckStateName;

    private static int editTruckId;
    public void setEditTruckId(int truckId){
        editTruckId = truckId;
    }

    public HtmlInputText getNewSerial() {
        return newSerial;
    }

    public void setNewSerial(HtmlInputText newSerial) {
        this.newSerial = newSerial;
    }

    public HtmlInputText getNewCapacity() {
        return newCapacity;
    }

    public void setNewCapacity(HtmlInputText newCapacity) {
        this.newCapacity = newCapacity;
    }

    public HtmlInputText getNewDriversNumber() {
        return newDriversNumber;
    }

    public void setNewDriversNumber(HtmlInputText newDriversNumber) {
        this.newDriversNumber = newDriversNumber;
    }

    public HtmlSelectOneMenu getNewTruckState() {
        return newTruckState;
    }

    public void setNewTruckState(HtmlSelectOneMenu newTruckState) {
        this.newTruckState = newTruckState;
    }

    public void setTruck(TruckEntitySO truck)
    {
        this.truck = truck;
    }

    public Set<TruckEntitySO> getTruck() {
        if (truck == null) {
            int editId = editTruckId;
            this.truck = truckService.getTruckById(editId);
            this.newSerial.setValue(this.truck.getSerial());
            this.newCapacity.setValue(this.truck.getCapacity());
            this.newDriversNumber.setValue(this.truck.getDriversNumber());
            this.newTruckState.setValue(this.truck.getTruckStateIdTruckState().getTruckState());
        }
        Set<TruckEntitySO> result = new HashSet<>();
        result.add(truck);
        return result;
    }

    public List getTrucks() {
        return truckService.getAllTrucks();
    }

    public List getTruckStates(){
        return truckStateService.getAllTruckStates();
    }

    public Set getTruckStateNames() {
        Set<String> result = new HashSet<>();
        Set<TruckstateEntitySO> states = new HashSet<>();
        states.addAll(getTruckStates());
        for(TruckstateEntitySO state : states){
            result.add(state.getTruckState());
        }
        return result;

    }

    public String getTruckStateByTruck(){
        this.truckState = this.truck.getTruckStateIdTruckState();
        this.truckStateName = this.truckState.getTruckState();
        return this.truckStateName;
    }

    public String newTruck()
    {
        return "addTruck.xhtml?faces-redirect=true";
    }

    public String editTruck()
    {
        return "editTruck?faces-redirect=true";
    }

    public String delete()
    {
        int editId = editTruckId;
        TruckEntitySO truck = truckService.getTruckById(editId);
        truckService.deleteTruck(truck);
        return "trucks?faces-redirect=true";
    }
    public String update(String newSerial, String newCapacity, String newDriversNumber, String truckState)
    {
        this.truckState = truckStateService.getTruckStateByState(truckState);
        this.truck.setSerial(newSerial);
        this.truck.setCapacity(Double.valueOf(newCapacity));
        this.truck.setDriversNumber(Integer.valueOf(newDriversNumber));
        this.truck.setTruckStateIdTruckState(this.truckState);
        truckService.updateTruck(truck);
        return "trucks?faces-redirect=true";
    }

    public String create(String newSerial, String newCapacity, String newDriversNumber, String truckState)
    {
        TruckEntitySO truck = new TruckEntitySO();
        this.truckState = truckStateService.getTruckStateByState(truckState);
        truck.setSerial(newSerial);
        truck.setCapacity(Double.valueOf(newCapacity));
        truck.setDriversNumber(Integer.valueOf(newDriversNumber));
        truck.setTruckStateIdTruckState(this.truckState);
        truckService.addTruck(truck);
        return "trucks?faces-redirect=true";
    }


}
