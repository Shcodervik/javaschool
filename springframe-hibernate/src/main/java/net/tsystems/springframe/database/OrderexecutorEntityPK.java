package net.tsystems.springframe.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderexecutorEntityPK implements Serializable {
    private int idOrderExecutor;
    private int orderIdOrder;
    private int driverIdDriver;
    private int truckIdTruck;

    @Column(name = "idOrderExecutor")
    @Id
    public int getIdOrderExecutor() {
        return idOrderExecutor;
    }

    public void setIdOrderExecutor(int idOrderExecutor) {
        this.idOrderExecutor = idOrderExecutor;
    }

    @Column(name = "Order_idOrder")
    @Id
    public int getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(int orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    @Column(name = "Driver_idDriver")
    @Id
    public int getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(int driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    @Column(name = "Truck_idTruck")
    @Id
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
        OrderexecutorEntityPK that = (OrderexecutorEntityPK) o;
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
