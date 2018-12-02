/*
 * Copyright (c) 2018.
 */

package net.tsystems.springframe.services.objects;

import java.util.ArrayList;
import java.util.List;

public class CustomOrderExecutor {
    List<Integer> orderExecutors = new ArrayList<>();
    OrderEntitySO orderIdOrder;
    TruckEntitySO truckIdTruck;
    String drivers;

    public OrderEntitySO getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(OrderEntitySO order) {
        this.orderIdOrder = order;
    }

    public TruckEntitySO getTruckIdTruck() {
        return truckIdTruck;
    }

    public void setTruckIdTruck(TruckEntitySO truck) {
        this.truckIdTruck = truck;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }

    public List<Integer> getOrderExecutors(){
        return orderExecutors;
    }
}
