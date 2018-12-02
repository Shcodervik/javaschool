package net.tsystems.springframe.frontend.component;

import net.tsystems.springframe.services.objects.*;
import net.tsystems.springframe.services.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
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

    private String newOriginName = null;
    private String newDestinationName = null;

   // RoutepointtypeEntitySO routePointType;
   // CityEntitySO cityEntitySO;

    private HtmlInputText newDescription;
    private HtmlInputText newWeight;
    private HtmlSelectOneMenu newCargoState;
    private HtmlSelectOneMenu newOriginCity;
    private HtmlSelectOneMenu newDestinationCity;
   // private String cargoStateName;


    private static int editCargoId;

    public void setNewOriginName(String newOriginName){
        //this.newOriginName = newOriginName;
    }

    public String getNewOriginName(){
        return this.newOriginName;
    }

    public void setNewDestinationName(String newDestinationName){
        //this.newDestinationName = newDestinationName;
    }

    public String getNewDestinationName(){
        return this.newDestinationName;
    }

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
    public RoutepointEntitySO getRoutePointOrigin() {
        return routePointOrigin;
    }

    public void setRoutePointOrigin(RoutepointEntitySO routePointOrigin) {
        this.routePointOrigin = routePointOrigin;
    }

    public RoutepointEntitySO getRoutePointDestination() {
        return routePointDestination;
    }

    public void setRoutePointDestination(RoutepointEntitySO routePointDestination) {
        this.routePointDestination = routePointDestination;
    }

    public CargoEntitySO getCargo() {
        final List<RoutepointEntitySO> points = new ArrayList<>();

        if (cargo == null) {
            int editId = editCargoId;
            this.cargo = cargoService.getCargoById(editId);

            this.newDescription.setValue(this.cargo.getDescription());
            this.newWeight.setValue(this.cargo.getWeight());
            this.newCargoState.setValue(this.cargo.getCargoStateIdCargoState().getCargoState());

            points.addAll(routepointService.getRoutePointsByCargo(this.cargo));
            if (!points.isEmpty()) {
                this.routePointOrigin = points.get(0);
                this.routePointDestination = points.get(1);
                this.newOriginCity.setValue(this.routePointOrigin.getCityIdCity().getName());
                this.newDestinationCity.setValue(this.routePointDestination.getCityIdCity().getName());
                this.newDestinationName = (this.routePointDestination.getCityIdCity().getName());
                this.newOriginName = (this.routePointOrigin.getCityIdCity().getName());
            }
        }
        CargoEntitySO result = cargo;
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
       // int editId = this.editCargoId;
        //this.cargo = cargoService.getCargoById(editId);
        return "editCargo?faces-redirect=true";
    }

    public String delete() {
        int editId = editCargoId;
        CargoEntitySO cargo = cargoService.getCargoById(editId);

        final List<RoutepointEntitySO> points = new ArrayList<>();
        points.addAll(this.routepointService.getRoutePointsByCargo(cargo));

        routepointService.deleteRoutePoints(points);
        cargoService.deleteCargo(cargo);
        return "cargoes?faces-redirect=true";
    }

    public String update(String newDescription, String newWeight, String cargoState, String newOriginCity, String newDestinationCity) {
        int editId = editCargoId;
        CargoEntitySO cargo = cargoService.getCargoById(editId);
        final List<RoutepointEntitySO> points = new ArrayList<>();
        points.addAll(this.routepointService.getRoutePointsByCargo(cargo));
        points.get(0).setCityIdCity(this.cityService.getCityByName(newOriginName));
        points.get(1).setCityIdCity(this.cityService.getCityByName(newDestinationName));


       /* origin.setCityIdCity(this.cityService.getCityByName(newOriginCity));
        destination.setCityIdCity(this.cityService.getCityByName(newDestinationCity));
        origin.setRoutePointTypeIdRpType(this.routepointtypeService.getRoutePointTypeById(1));
        destination.setRoutePointTypeIdRpType(this.routepointtypeService.getRoutePointTypeById(2));
        origin.setCargoIdCargo(cargo);
        destination.setCargoIdCargo(cargo);*/

        //points.add(origin);
        //points.add(destination);

        this.cargoState = cargoStateService.getCargoStateByState(cargoState);

        cargo.setDescription(newDescription);
        cargo.setWeight(Double.valueOf(newWeight));
        cargo.setCargoStateIdCargoState(this.cargoState);

        cargoService.updateCargo(cargo);
        routepointService.updateRoutePoints(points);
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

        origin.setRoutePointTypeIdRpType(this.routepointtypeService.getRoutePointTypeById(1));
        destination.setRoutePointTypeIdRpType(this.routepointtypeService.getRoutePointTypeById(2));
        origin.setCargoIdCargo(cargo);
        origin.setCityIdCity(this.cityService.getCityByName(newOriginCity));
        destination.setCargoIdCargo(cargo);
        destination.setCityIdCity(this.cityService.getCityByName(newDestinationCity));

        cargoService.addCargo(cargo);
        routepointService.addRoutePoint(origin);
        routepointService.addRoutePoint(destination);

        return "cargoes?faces-redirect=true";
    }

    public void changeCityOrigin (ValueChangeEvent event) {
        newOriginName = event.getNewValue().toString();
    }

    public void changeCityDestination (ValueChangeEvent event) {
        newDestinationName = event.getNewValue().toString();
    }


    private void clearItems(){
        this.cargo = null;
        this.routePointOrigin = null;
        this.routePointDestination = null;
        this.newDescription = null;
        this.newWeight = null;
        this.newCargoState = null;
        this.newOriginCity = null;
        this.newDestinationCity = null;
    }
}
