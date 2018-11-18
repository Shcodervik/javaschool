package net.tsystems.springframe.frontend.component;

import net.tsystems.springframe.services.objects.*;
import net.tsystems.springframe.services.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Been for cargo. It joins cargo and cargoState for viewing.
 *
 * @author shcodervik
 *
 */

@SessionScoped
@ManagedBean(name = "cargoesBean")
@Component(value = "cargoesBean")
public class CargoesBean implements Serializable {

    private CargoService cargoService;
    private CargostateService cargoStateService;
    private RoutepointtypeService routepointtypeService;
    private RoutepointService routepointService;
    private CityService cityService;

    @Autowired
    public void CargoesBean(CargoService cargoService,
                            CargostateService cargoStateService,
                            RoutepointtypeService routepointtypeService,
                            RoutepointService routepointService,
                            CityService cityService){
        this.cargoService = cargoService;
        this.cargoStateService = cargoStateService;
        this.routepointtypeService = routepointtypeService;
        this.routepointService = routepointService;
        this.cityService = cityService;
    }



    CargoEntitySO cargo;
    CargostateEntitySO cargoState;
    RoutepointEntitySO routePointOrigin;
    RoutepointEntitySO routePointDestination;
    RoutepointtypeEntitySO routePointType;
    CityEntitySO cityEntitySO;

    private HtmlInputText newDescription;
    private HtmlInputText newWeight;
    private HtmlSelectOneMenu newCargoState;
    private HtmlSelectOneMenu newOriginCity;
    private HtmlSelectOneMenu newDestinationCity;
    private String cargoStateName;

    private static int editCargoId;

    public void setEditCargoId(int cargoId) {
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

    public HtmlSelectOneMenu getNewOriginCity() {
        return newOriginCity;
    }

    public void setNewOriginCity(HtmlSelectOneMenu newOriginCity) {
        this.newOriginCity = newOriginCity;
    }

    public HtmlSelectOneMenu getNewDestinationCity() {
        return newDestinationCity;
    }

    public void setNewDestinationCity(HtmlSelectOneMenu newDestinationCity) {
        this.newDestinationCity = newDestinationCity;
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

    public List<CargoEntitySO> getCargoes() {
        return cargoService.getAllCargoes();
    }

    private List<CargostateEntitySO> getCargoStates() {
        return cargoStateService.getAllCargoStates();
    }

    public Set<String> getCargoStateNames() {
        Set<String> result = new HashSet<>();
        Set<CargostateEntitySO> states = new HashSet<>(getCargoStates());
        for (CargostateEntitySO state : states) {
            result.add(state.getCargoState());
        }
        return result;

    }

    private List getRoutePoints() {
        return routepointService.getAllRoutePoints();
    }

    public Set<String> getRoutePointTypes() {
        Set<String> result = new HashSet<>();
        Set<RoutepointtypeEntitySO> routepointtypes = new HashSet<>(getRoutePoints());
        for (RoutepointtypeEntitySO type : routepointtypes) {
            result.add(type.getRpType());
        }
        return result;

    }

    public List getAllCities() {
        return cityService.getAllCities();
    }

    public Set getCities() {
        Set<String> result = new HashSet<>();
        Set<CityEntitySO> cities = new HashSet<>();
        cities.addAll(getAllCities());
        for(CityEntitySO city : cities){
            result.add(city.getName());
        }
        return result;

    }

    public String newCargo() {
        clearItems();
        return "addCargo.xhtml?faces-redirect=true";
    }

    public String editCargo() {
        clearItems();
        int editId = this.editCargoId;
        this.cargo = cargoService.getCargoById(editId);
        return "editCargo?faces-redirect=true";
    }

    public String delete() {
        int editId = editCargoId;
        CargoEntitySO cargo = cargoService.getCargoById(editId);
        cargoService.deleteCargo(cargo);
        return "cargoes?faces-redirect=true";
    }

    public String update(String newDescription, String newWeight, String cargoState) {
        this.cargoState = cargoStateService.getCargoStateByState(cargoState);
        this.cargo.setDescription(newDescription);
        this.cargo.setWeight(Double.valueOf(newWeight));
        this.cargo.setCargoStateIdCargoState(this.cargoState);
        cargoService.updateCargo(cargo);
        return "cargoes?faces-redirect=true";
    }

    public String create(String newDescription, String newWeight, String cargoState,
                         String newOriginCity, String newDestinationCity) {
        CargoEntitySO cargo = new CargoEntitySO();
        RoutepointEntitySO origin = new RoutepointEntitySO();
        RoutepointEntitySO destination = new RoutepointEntitySO();
        this.cargoState = cargoStateService.getCargoStateByState(cargoState);
        cargo.setDescription(newDescription);
        cargo.setWeight(Double.valueOf(newWeight));
        cargo.setCargoStateIdCargoState(this.cargoState);
        cargoService.addCargo(cargo);
        origin.setRoutePointTypeIdRpType(this.routePointType);
       // this.routePointOrigin = routepointService.getRoutePointById(
      //          origin.getRoutePointTypeIdRpType(this.routePointType).getIdRpType());
       // origin.setCityIdCity(newOriginCity);
        return "cargoes?faces-redirect=true";
    }


    private void clearItems(){
        this.cargo = null;
        this.newDescription = null;
        this.newWeight = null;
        this.newCargoState = null;
        this.newOriginCity = null;
        this.newDestinationCity = null;
    }
}
