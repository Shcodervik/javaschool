/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.frontend.component;

import net.tsystems.springframe.database.OrderEntity;
import net.tsystems.springframe.services.Utils;
import net.tsystems.springframe.services.objects.*;
import net.tsystems.springframe.services.services.*;
import org.primefaces.component.selectmanycheckbox.SelectManyCheckbox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SessionScoped
@ManagedBean(name = "ordersBean")
@Component(value = "ordersBean")
public class OrdersBean implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(OrdersBean.class);

    @Autowired
    public void OrdersBean(OrderService orderService,
                           OrderexecutorService orderExecutorService,
                           CargoService cargoService,
                           TruckService truckService,
                           DriverService driverService,
                           RoutepointService routepointService,
                           RoadService roadService,
                           CityService cityService
                           ){
        this.orderService = orderService;
        this.orderExecutorService = orderExecutorService;
        this.cargoService = cargoService;
        this.truckService = truckService;
        this.driverService = driverService;
        this.routepointService = routepointService;
        this.roadService = roadService;
        this.cityService = cityService;

    }


    private OrderService orderService;
    private OrderexecutorService orderExecutorService;
    private CargoService cargoService;
    private TruckService truckService;
    private DriverService driverService;
    private RoutepointService routepointService;
    private RoadService roadService;
    private CityService cityService;

    private OrderEntitySO order;
    private OrderexecutorEntitySO orderexecutor;
    private DriverEntitySO driver;
    private TruckEntitySO truck;
    private CargoEntitySO cargo;
    private RoadEntitySO road;

    private HtmlInputText newClosed;
    private HtmlInputText newCreateDT;
    private HtmlInputText newCloseDT;

    private HtmlSelectOneMenu newTruck;


    private SelectItem[] selectedRoutePoints;
    private SelectManyCheckbox selectedCargoes;
    private SelectManyCheckbox selectedDrivers;
    private List<RoutepointEntitySO> routePointsInOrder;
    private List<DriverEntitySO> driversForOrder;

    private List<TruckEntitySO> trucks;
    private List<OrderexecutorEntitySO> executorsForOrder;
    private Set<DriverEntitySO> drvs;
    private Set<String> truckSerials;

    private int editOrderExecutorId;
    private int editOrderId;
    private int countDriversForOrder;

    private double currentWeight;  //in tons

    public List<OrderexecutorEntitySO> getExecutorsForOrder() {
        return executorsForOrder;
    }

    public void setExecutorsForOrder(List<OrderexecutorEntitySO> executorsForOrder) {
        this.executorsForOrder = executorsForOrder;
    }

    public HtmlSelectOneMenu getNewTruck() {
        return newTruck;
    }


    public List<TruckEntitySO> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<TruckEntitySO> trucks) {
        this.trucks = trucks;
    }

    public int getEditOrderExecutorId() {
        return editOrderExecutorId;
    }

    public int getCountDriversForOrder() {
        return countDriversForOrder;
    }

    public void setCountDriversForOrder(int countDriversForOrder) {
        this.countDriversForOrder = countDriversForOrder;
    }

    public void setNewTruck(HtmlSelectOneMenu newTruck) {
        this.newTruck = newTruck;
    }

    public Double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setEditOrderExecutorId(int editOrderExecutorId) {
        this.editOrderExecutorId = editOrderExecutorId;
    }
    public SelectItem[] getSelectedRoutePoints(){
        return this.selectedRoutePoints;
    }
    public void setEditOrderId(int editOrderId) {
        this.editOrderId = editOrderId;
    }

    public void setSelectedRoutePoints(SelectItem[] items){
        this.selectedRoutePoints = items;
    }
    public HtmlInputText getNewClosed() {
        return newClosed;
    }

    public void setNewClosed(HtmlInputText newClosed) {
        this.newClosed = newClosed;
    }

    public HtmlInputText getNewCreateDT() {
        return newCreateDT;
    }

    public void setNewCreateDT(HtmlInputText newCreateDT) {
        this.newCreateDT = newCreateDT;
    }

    public HtmlInputText getNewCloseDT() {
        return newCloseDT;
    }

    public void setNewCloseDT(HtmlInputText newCloseDT) {
        this.newCloseDT = newCloseDT;
    }

    public SelectManyCheckbox getSelectedCargoes() {
        return selectedCargoes;
    }

    public void setSelectedCargoes(SelectManyCheckbox selected) {
        this.selectedCargoes = selected;
    }

    public SelectManyCheckbox getSelectedDrivers() {
        return selectedDrivers;
    }

    public void setSelectedDrivers(SelectManyCheckbox selectedDrivers) {
        this.selectedDrivers = selectedDrivers;
    }

    public Set<String> getTruckSerials() {
        return truckSerials;
    }

    public void setTruckSerials(Set<String> truckSerials) {
        this.truckSerials = truckSerials;
    }

    public List getOrders() {
        List result;
        try{
            result = orderService.getAllOrders();
        }
        catch(NullPointerException npe){
            npe.printStackTrace();
            result = null;
        }

        return result;
    }

    public List getOrderExecutors(){
        List result;
        try{
            result = orderExecutorService.getAllOrderexecutors();
        }catch(NullPointerException npe){
            npe.printStackTrace();
            result = null;
        }
        return result;
    }

    public List getWorkingOrderExecutors(){
         List<CustomOrderExecutor> result;
        try{
            List<OrderexecutorEntitySO> executors = orderExecutorService.getWorkingOrderexecutors();
            HashMap<OrderEntitySO, ArrayList<OrderexecutorEntitySO>> splittedMap = new HashMap<>();
            for(OrderexecutorEntitySO oe : executors)
            {
                if (!splittedMap.containsKey(oe.getOrderIdOrder()))
                    splittedMap.put(oe.getOrderIdOrder(), new ArrayList<>());

                splittedMap.get(oe.getOrderIdOrder()).add(oe);
            }
            if (!splittedMap.isEmpty()) {
                result = new ArrayList<>();
                for(Map.Entry<OrderEntitySO, ArrayList<OrderexecutorEntitySO>> e : splittedMap.entrySet()) {
                    if (!e.getValue().isEmpty()) {
                        CustomOrderExecutor coe = new CustomOrderExecutor();
                        coe.setOrderIdOrder(e.getKey());
                        coe.setTruckIdTruck(e.getValue().get(0).getTruckIdTruck());
                        StringBuilder driversBuilder = new StringBuilder();
                        for (int i = 0; i < e.getValue().size(); i++)
                        {
                            OrderexecutorEntitySO oe = e.getValue().get(i);
                            driversBuilder.append(oe.getDriverIdDriver().getName());
                            driversBuilder.append(' ');
                            driversBuilder.append(oe.getDriverIdDriver().getSurname());
                            if ((i + 1) < e.getValue().size())
                                driversBuilder.append(", \n");
                            coe.getOrderExecutors().add(oe.getIdOrderExecutor());
                        }
                        coe.setDrivers(driversBuilder.toString());
                        result.add(coe);
                    }
                }
                logger.error("ok");
                return result;
            }
        }catch(NullPointerException npe){
            npe.printStackTrace();
            result = null;
        }
        return null;
    }


    public List<CustomCargo> getAllCargoesByOrder(){
        List<RoutepointEntitySO> routePoints = routepointService.getRoutePointsByOrder(this.order);
        List<RoadEntitySO> roads = roadService.getAllRoads();
        List<CustomCargo> result = new ArrayList<>();
        int count = 0;
        CargoEntitySO crgSO;
        List<RoutepointEntitySO> routePointsForCargo = new ArrayList<>();
        for (RoutepointEntitySO routeP:routePoints) {
            CustomCargo crg = new CustomCargo();
            if(count%2 == 1){
                routePointsForCargo.add(routeP);
                crgSO = routeP.getCargoIdCargo();
                crg.setIdCargo(crgSO.getIdCargo());
                crg.setCargoStateIdCargoState(crgSO.getCargoStateIdCargoState());
                crg.setDescription(crgSO.getDescription());
                crg.setWeight(crgSO.getWeight());
                String origin = cityService.getCityById(routePointsForCargo.get(0).getCityIdCity().getIdCity()).getName();
                String destination = cityService.getCityById(routePointsForCargo.get(1).getCityIdCity().getIdCity()).getName();
                crg.setRoad("From "+origin+" to "+destination);
               /* Double[] params = getParams(origin, destination, crg.getRoadLength(), crg.getRoadSpeed());
                crg.setRoadLength(params[0]);
                crg.setRoadSpeed(params[1]);
                crg.setTimeInRoad(params[3]);
                result.add(crg);*/
                for (RoadEntitySO r:roads) {
                    if(((r.getOriginCity().getName().equals(origin))
                            && (r.getDestinationCity().getName().equals(destination)))
                            ||
                            ((r.getDestinationCity().getName().equals(origin))
                                    &&(r.getOriginCity().getName().equals(destination)))){

                        crg.setRoadLength(r.getLength());
                        crg.setRoadSpeed(r.getSpeedLimit());
                        crg.setTimeInRoad(Utils.roundResult(crg.getRoadLength()/crg.getRoadSpeed(),2));
                        result.add(crg);
                        break;
                    }
                }
                routePointsForCargo.clear();
            }
            else{
                routePointsForCargo.add(routeP);
            }
            count++;
        }
        return result;
    }

    public Double[] getParams(String origin,String destination, Double roadLength, Double roadSpeed){
        Double[] result = new Double[3];
        List<RoadEntitySO> roads = roadService.getAllRoads();
        for (RoadEntitySO r:roads) {
            if(((r.getOriginCity().getName().equals(origin))
                    && (r.getDestinationCity().getName().equals(destination)))
                    ||
                    ((r.getDestinationCity().getName().equals(origin))
                            &&(r.getOriginCity().getName().equals(destination)))){

                result[0] = r.getLength();
                result[1] = Double.valueOf(r.getSpeedLimit());
                result[2] = roadLength/roadSpeed;
                return result;
            }
        }
        return null;
    }

    public List<RoutepointEntitySO> getRoutePointsWithoutOrder(){
        List<RoutepointEntitySO> result = new ArrayList<RoutepointEntitySO>();
        result.addAll(routepointService.getRoutePointsWithoutOrder());
        return result;
    }

    public Set getRoutePoints() {
        Set<String> result = new HashSet<>();
        Set<RoutepointEntitySO> rps = new HashSet<>();
        rps.addAll(getRoutePointsWithoutOrder());
        for(RoutepointEntitySO rp : rps){
            result.add(rp.getCargoIdCargo().getIdCargo()+" "+rp.getCargoIdCargo().getDescription());
        }
        return result;

    }

    public String showCargoes() {
        clearItems();
        int editId = editOrderId;
        this.order = orderService.getOrderById(editId);
        return "showOrder.xhtml?faces-redirect=true";
    }

    public String newOrder() {
        clearItems();
        return "addOrder.xhtml?faces-redirect=true";
    }


    public String delete(List<Integer> orderExecutorIds) {
        OrderEntitySO order = null;
        for(Integer i : orderExecutorIds) {
            int editId = i;
            OrderexecutorEntitySO orderExecutor = orderExecutorService.getOrderexecutorById(editId);
            order = orderExecutor.getOrderIdOrder();
            orderExecutorService.deleteOrderexecutor(orderExecutor);
        }
        if(order!=null) {
            List<RoutepointEntitySO> routepoints = routepointService.getRoutePointsByOrder(order);
            if(!routepoints.isEmpty()) {
                for (RoutepointEntitySO rp : routepoints) {
                    rp.setOrderIdOrder(null);
                }
                routepointService.updateRoutePoints(routepoints);
            }
            orderService.deleteOrder(order);
        }
        return "orders?faces-redirect=true";
    }

    public String saveCargoesInOrder(SelectManyCheckbox rps){
        int idCarg;
        Pattern p = Pattern.compile("([0-9]{1,15})");
        List<String> selItemsStrings = new ArrayList<>();
        Object[] selItems = rps.getSelectedValues();
        for (Object o:selItems) {
            selItemsStrings.add(String.valueOf(o.toString()));
            logger.error(String.valueOf(o.toString()));
        }
        float weight = 0;
        for (String si:selItemsStrings) {
            Matcher m = p.matcher(si);
            if(m.find()) {
                idCarg = Integer.valueOf(m.group(0));
                logger.error(String.valueOf(idCarg));
                cargo = cargoService.getCargoById(idCarg);
                routePointsInOrder.addAll(routepointService.getRoutePointsByCargo(cargo));
                //double time = 0; the next step
                CargoEntitySO crg = new CargoEntitySO();
                int count = 0;
                for (RoutepointEntitySO rp : routePointsInOrder) {
                    if (count % 2 == 1) {
                        crg = rp.getCargoIdCargo();
                        weight += crg.getWeight();
                    }
                    count++;
                }
            }
        }
        currentWeight = Utils.roundResult(Double.valueOf(weight/1000),2); //return tons
        logger.error(String.valueOf(currentWeight));
        if(getTruckSerials().isEmpty()) {
            setTruckSerials(getTrucksSerials());
        }
        return "addOrder2step?faces-redirect=true";
    }

    public String saveTruckForOrder(String serial){

        truck = truckService.getTruckBySerial(serial);
        countDriversForOrder = truck.getDriversNumber();
        return "addOrder3step?faces-redirect=true";
    }

    public Set getDriversInOrder() {
        Set<String> result = new HashSet<>();
        if(drvs.isEmpty()) {
            drvs.addAll(driverService.getDriversForOrder());
        }
        for(DriverEntitySO drv : drvs){
            result.add(drv.getUIN() + " " + drv.getName() + " " + drv.getSurname());
        }
        return result;

    }

    public String saveOrder(SelectManyCheckbox drvs){
        String uinDriver;
        Pattern p = Pattern.compile("([0-9]{1,15})");
        List<String> selItemsStrings = new ArrayList<>();
        Object[] selItems = drvs.getSelectedValues();
        for (Object o:selItems) {
            selItemsStrings.add(String.valueOf(o.toString()));
            logger.error(String.valueOf(o.toString()));
        }
        for (String si:selItemsStrings) {
            Matcher m = p.matcher(si);
            if(m.find()) {
                uinDriver = m.group(0);
                logger.error(String.valueOf(uinDriver));
                driver = driverService.getDriverByUIN(uinDriver);
                driversForOrder.add(driver);
            }
        }
        final List<OrderexecutorEntitySO> executors = new ArrayList<>();
        order = new OrderEntitySO();
        order.setClosed(true);
        order.setCreateDT(new Date());
        for (int i=0;i<countDriversForOrder;i++) {
            orderexecutor = new OrderexecutorEntitySO();
            orderexecutor.setOrderIdOrder(order);
            orderexecutor.setTruckIdTruck(truck);
            orderexecutor.setDriverIdDriver(driversForOrder.get(i));
            executorsForOrder.add(orderexecutor);
            orderexecutor = null;
        }
        orderService.addOrder(order);
        orderExecutorService.createOrderexecutorsForOrder(executorsForOrder);
        for (RoutepointEntitySO rp: routePointsInOrder) {
            rp.setOrderIdOrder(order);
        }
        routepointService.updateRoutePoints(routePointsInOrder);
        return "orders?faces-redirect=true";
    }

    public String create(String newClosed, String newCreateDt, String newCloseDt) {
        OrderEntitySO order = new OrderEntitySO();
        order.setClosed(Utils.byteToBool(Byte.valueOf(newClosed)));
        try {
            this.order.setCreateDT(Utils.stringToDate(newCreateDt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            this.order.setCloseDT(Utils.stringToDate(newCloseDt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        orderService.addOrder(order);
        return "orders?faces-redirect=true";
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @Autowired
    public void setOrderExecutorService(OrderexecutorService orderExecutorService) {
        this.orderExecutorService = orderExecutorService;
    }

    public List getTrucks(Double capacity){
        if (trucks.isEmpty()) {
            trucks = truckService.getTrucksForOrder(capacity);
        }
        return trucks;
    }

    public Set<String> getTrucksSerials(){
        if(truckSerials.isEmpty()) {
            Set<String> result = new HashSet<>();
            //Set<TruckEntitySO> trucks = new HashSet<>();
            //trucks.addAll(getTrucks(getCurrentWeight()));
            if (trucks.isEmpty()) {
                trucks = truckService.getTrucksForOrder(getCurrentWeight());
            }
            for (TruckEntitySO truck : trucks) {
                result.add(truck.getSerial());
            }
            truckSerials.addAll(result);
        }
        return truckSerials;
    }

    public void clearItems(){
        this.order = null;
        this.newClosed = null;
        this.newCreateDT = null;
        this.newCloseDT = null;
        this.truck = null;
        this.countDriversForOrder = 0;
        this.driversForOrder = new ArrayList<>();
        this.orderexecutor = null;
        this.currentWeight = 0;
        this.selectedRoutePoints = null;
        this.selectedCargoes = null;
        this.selectedDrivers = null;
        this.drvs = new HashSet<>();
        this.executorsForOrder = new ArrayList<>();
        this.trucks = new ArrayList<>();
        this.truckSerials  = new HashSet<>();
        this.routePointsInOrder = new ArrayList<>();

    }
}
