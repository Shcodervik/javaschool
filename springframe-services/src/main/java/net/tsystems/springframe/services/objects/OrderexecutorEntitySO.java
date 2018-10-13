package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class OrderexecutorEntitySO {
    private int idOrderExecutor;
    private OrderEntitySO orderIdOrder;
    private DriverEntitySO driverIdDriver;
    private TruckEntitySO truckIdTruck;

    public int getIdOrderExecutor() {
        return idOrderExecutor;
    }

    public void setIdOrderExecutor(int idOrderExecutor) {
        this.idOrderExecutor = idOrderExecutor;
    }

    public OrderEntitySO getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(OrderEntitySO orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    public DriverEntitySO getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(DriverEntitySO driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    public TruckEntitySO getTruckIdTruck() {
        return truckIdTruck;
    }

    public void setTruckIdTruck(TruckEntitySO truckIdTruck) {
        this.truckIdTruck = truckIdTruck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderexecutorEntitySO that = (OrderexecutorEntitySO) o;
        return idOrderExecutor == that.idOrderExecutor &&
                Objects.equals(orderIdOrder, that.orderIdOrder) &&
                Objects.equals(driverIdDriver, that.driverIdDriver) &&
                Objects.equals(truckIdTruck, that.truckIdTruck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrderExecutor, orderIdOrder, driverIdDriver, truckIdTruck);
    }
}
