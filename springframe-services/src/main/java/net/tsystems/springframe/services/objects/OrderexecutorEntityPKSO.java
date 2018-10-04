package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class OrderexecutorEntityPKSO {
    private int idOrderExecutor;
    private int orderIdOrder;
    private int driverIdDriver;
    private int truckIdTruck;

    public int getIdOrderExecutor() {
        return idOrderExecutor;
    }

    public void setIdOrderExecutor(int idOrderExecutor) {
        this.idOrderExecutor = idOrderExecutor;
    }

    public int getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(int orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    public int getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(int driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    public int getTruckIdTruck() {
        return truckIdTruck;
    }

    public void setTruckIdTruck(int truckIdTruck) {
        this.truckIdTruck = truckIdTruck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderexecutorEntityPKSO that = (OrderexecutorEntityPKSO) o;
        return idOrderExecutor == that.idOrderExecutor &&
                orderIdOrder == that.orderIdOrder &&
                driverIdDriver == that.driverIdDriver &&
                truckIdTruck == that.truckIdTruck;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrderExecutor, orderIdOrder, driverIdDriver, truckIdTruck);
    }
}
