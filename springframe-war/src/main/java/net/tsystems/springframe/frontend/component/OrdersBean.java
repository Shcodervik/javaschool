/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.frontend.component;

import net.tsystems.springframe.services.Utils;
import net.tsystems.springframe.services.objects.OrderEntitySO;
import net.tsystems.springframe.services.objects.OrderexecutorEntitySO;
import net.tsystems.springframe.services.services.OrderService;
import net.tsystems.springframe.services.services.OrderexecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SessionScoped
@ManagedBean(name = "ordersBean")
@Component(value = "ordersBean")
public class OrdersBean implements Serializable {

    @Autowired
    @Qualifier("orderService")
    private OrderService orderService;

    @Autowired
    @Qualifier("orderExecutorService")
    private OrderexecutorService orderExecutorService;

    OrderEntitySO order;
    OrderexecutorEntitySO orderexecutor;

    private HtmlInputText newClosed;
    private HtmlInputText newCreateDT;
    private HtmlInputText newCloseDT;

    private static int editOrderId;

    public static void setEditOrderId(int editOrderId) {
        OrdersBean.editOrderId = editOrderId;
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

    public Set<OrderEntitySO> getOrder() {
        if (order == null) {
            int editId = editOrderId;
            this.order = orderService.getOrderById(editId);
            this.newClosed.setValue(this.order.getClosed());
            this.newCreateDT.setValue(this.order.getCreateDt());
            this.newCloseDT.setValue(this.order.getCloseDt());
        }
        Set<OrderEntitySO> result = new HashSet<>();
        result.add(order);
        return result;
    }

    public String newOrder() {
        clearItems();
        return "addOrder.xhtml?faces-redirect=true";
    }
    public String editOrder() {
        clearItems();
        int editId = this.editOrderId;
        this.order = orderService.getOrderById(editId);
        return "editOrder?faces-redirect=true";
    }

    public String delete() {
        int editId = editOrderId;
        OrderEntitySO order = orderService.getOrderById(editId);
        orderService.deleteOrder(order);
        return "orders?faces-redirect=true";
    }

    public String update(String newClosed, String newCreateDt, String newCloseDt) {
        this.order.setClosed(Utils.byteToBool(Byte.valueOf(newClosed)));
        try {
            this.order.setCreateDt(Utils.stringToDate(newCreateDt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            this.order.setCloseDt(Utils.stringToDate(newCloseDt));
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
            this.order.setCreateDt(Utils.stringToDate(newCreateDt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            this.order.setCloseDt(Utils.stringToDate(newCloseDt));
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
