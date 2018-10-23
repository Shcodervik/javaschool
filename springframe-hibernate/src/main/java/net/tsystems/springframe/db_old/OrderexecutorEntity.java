package net.tsystems.springframe.db_old;

import javax.persistence.*;

@Entity
@Table(name = "orderexecutor")
public class OrderexecutorEntity {
    private int idOrderExecutor;
    private DriverEntity driverIdDriver;
    private OrderEntity orderIdOrder;
    private TruckEntity truckIdTruck;

    @Id
    @Column(name = "idOrderExecutor", nullable = false)
    public int getIdOrderExecutor() {
        return idOrderExecutor;
    }

    public void setIdOrderExecutor(int idOrderExecutor) {
        this.idOrderExecutor = idOrderExecutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderexecutorEntity that = (OrderexecutorEntity) o;

        if (idOrderExecutor != that.idOrderExecutor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idOrderExecutor;
    }

    @OneToOne
    @JoinColumn(name = "Driver_idDriver", referencedColumnName = "idDriver", nullable = false)
    public DriverEntity getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(DriverEntity driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    @OneToOne
    @JoinColumn(name = "Order_idOrder", referencedColumnName = "idOrder", nullable = false)
    public OrderEntity getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(OrderEntity orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    @OneToOne
    @JoinColumn(name = "Truck_idTruck", referencedColumnName = "idTruck", nullable = false)
    public TruckEntity getTruckIdTruck() {
        return truckIdTruck;
    }

    public void setTruckIdTruck(TruckEntity truckIdTruck) {
        this.truckIdTruck = truckIdTruck;
    }
}