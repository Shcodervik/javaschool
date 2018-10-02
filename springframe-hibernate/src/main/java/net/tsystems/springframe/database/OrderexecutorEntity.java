package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderexecutor", schema = "logiweb")
@IdClass(OrderexecutorEntityPK.class)
public class OrderexecutorEntity {
    private int idOrderExecutor;
    private int orderIdOrder;
    private int driverIdDriver;
    private int truckIdTruck;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idOrderExecutor")
    public int getIdOrderExecutor() {
        return idOrderExecutor;
    }

    public void setIdOrderExecutor(int idOrderExecutor) {
        this.idOrderExecutor = idOrderExecutor;
    }

    @Id
    @Column(name = "Order_idOrder")
    public int getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(int orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    @Id
    @Column(name = "Driver_idDriver")
    public int getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(int driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    @Id
    @Column(name = "Truck_idTruck")
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
        OrderexecutorEntity that = (OrderexecutorEntity) o;
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
