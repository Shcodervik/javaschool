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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import java.io.Serializable;
import java.text.ParseException;
import java.util.*;

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
                           RoutepointService routepointService
                           ){
        this.orderService = orderService;
        this.orderExecutorService = orderExecutorService;
        this.cargoService = cargoService;
        this.truckService = truckService;
        this.driverService = driverService;
        this.routepointService = routepointService;

    }


    private OrderService orderService;
    private OrderexecutorService orderExecutorService;
    private CargoService cargoService;
    private TruckService truckService;
    private DriverService driverService;
    private RoutepointService routepointService;

    OrderEntitySO order;
    OrderexecutorEntitySO orderexecutor;
    DriverEntitySO driver;
    TruckEntitySO truck;
    CargoEntitySO cargo;

    private HtmlInputText newClosed;
    private HtmlInputText newCreateDT;
    private HtmlInputText newCloseDT;

    private static int editOrderExecutorId;

    public static void setEditOrderExecutorId(int editOrderId) {
        OrdersBean.editOrderExecutorId = editOrderId;
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

   // public OrderEntitySO

    public OrderEntitySO getOrderExecutor() {
        if (order == null) {
            int editId = editOrderExecutorId;
            this.order = orderService.getOrderById(editId);
            this.newClosed.setValue(this.order.getClosed());
            this.newCreateDT.setValue(this.order.getCreateDT());
            this.newCloseDT.setValue(this.order.getCloseDT());
        }
        OrderEntitySO result = order;
        return result;
    }

    public String newOrder() {
        clearItems();
        return "addOrder.xhtml?faces-redirect=true";
    }
    public String editOrder() {
        clearItems();
        int editId = this.editOrderExecutorId;
        this.order = orderService.getOrderById(editId);
        return "editOrder?faces-redirect=true";
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

    public String update(String newClosed, String newCreateDt, String newCloseDt) {
        this.order.setClosed(Utils.byteToBool(Byte.valueOf(newClosed)));
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
        orderService.updateOrder(order);
        return "cargoes?faces-redirect=true";
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

    public void clearItems(){
        this.order = null;
        this.newClosed = null;
        this.newCreateDT = null;
        this.newCloseDT = null;
    }
}
