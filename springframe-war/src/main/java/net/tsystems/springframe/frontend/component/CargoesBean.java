package net.tsystems.springframe.frontend.component;

import net.tsystems.springframe.services.objects.CargoEntitySO;
import net.tsystems.springframe.services.objects.CargostateEntitySO;
import net.tsystems.springframe.services.services.CargoService;
import net.tsystems.springframe.services.services.CargostateService;
import net.tsystems.springframe.services.services.impl.CargoServiceImpl;
import net.tsystems.springframe.services.services.impl.CargostateServiceImpl;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ViewScoped
@ManagedBean(name = "cargoesBean")
@Component(value = "cargoesBean")
public class CargoesBean implements Serializable {
    private CargoService cargoService = new CargoServiceImpl();
    private CargostateService cargoStateService = new CargostateServiceImpl();

    CargoEntitySO cargo;
    CargostateEntitySO cargoState;

    private HtmlInputText newDescription;
    private HtmlInputText newWeight;
    private HtmlSelectOneMenu newCargoState;
    private String cargoStateName;

    private static int editCargoId;
    public void setEditCargoId(int cargoId){
        editCargoId = cargoId;
    }

    public HtmlInputText getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(HtmlInputText newDescription) {
        this.newDescription = newDescription;
    }

    public HtmlInputText getNewWeight() {
        return newWeight;
    }

    public void setNewWeight(HtmlInputText newWeight) {
        this.newWeight = newWeight;
    }

    public HtmlSelectOneMenu getNewCargoState() {
        return newCargoState;
    }

    public void setNewCargoState(HtmlSelectOneMenu newCargoState) {
        this.newCargoState = newCargoState;
    }

    public Set<CargoEntitySO> getCargo() {
        if (cargo == null) {
            int editId = editCargoId;
            this.cargo = cargoService.getCargoById(editId);
            this.newDescription.setValue(this.cargo.getDescription());
            this.newWeight.setValue(this.cargo.getWeight());
            this.newCargoState.setValue(this.cargo.getCargoStateIdCargoState().getCargoState());
        }
        Set<CargoEntitySO> result = new HashSet<>();
        result.add(cargo);
        return result;
    }

    public List getCargoes() {
        return cargoService.getAllCargoes();
    }

    public List getCargoStates(){
        return cargoStateService.getAllCargoStates();
    }

    public Set getCargoStateNames() {
        Set<String> result = new HashSet<>();
        Set<CargostateEntitySO> states = new HashSet<>();
        states.addAll(getCargoStates());
        for(CargostateEntitySO state : states){
            result.add(state.getCargoState());
        }
        return result;

    }

    public String newCargo()
    {
        return "addCargo.xhtml?faces-redirect=true";
    }

    public String editCargo()
    {
        return "editCargo?faces-redirect=true";
    }

    public String delete()
    {
        int editId = editCargoId;
        CargoEntitySO cargo = cargoService.getCargoById(editId);
        cargoService.deleteCargo(cargo);
        return "cargoes?faces-redirect=true";
    }

    public String update(String newDescription, String newWeight, String cargoState)
    {
        this.cargoState = cargoStateService.getCargoStateByState(cargoState);
        this.cargo.setDescription(newDescription);
        this.cargo.setWeight(Double.valueOf(newWeight));
        this.cargo.setCargoStateIdCargoState(this.cargoState);
        cargoService.updateCargo(cargo);
        return "cargoes?faces-redirect=true";
    }

    public String create(String newDescription, String newWeight, String cargoState)
    {
        CargoEntitySO cargo = new CargoEntitySO();
        this.cargoState = cargoStateService.getCargoStateByState(cargoState);
        cargo.setDescription(newDescription);
        cargo.setWeight(Double.valueOf(newWeight));
        cargo.setCargoStateIdCargoState(this.cargoState);
        cargoService.addCargo(cargo);
        return "cargoes?faces-redirect=true";
    }
}
