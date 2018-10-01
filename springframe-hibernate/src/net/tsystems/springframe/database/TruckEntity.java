package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "truck", schema = "logiweb")
@IdClass(TruckEntityPK.class)
public class TruckEntity {
    private int idTruck;
    private String serial;
    private Double capacity;
    private int truckStateIdTruckState;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idTruck")
    public int getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(int idTruck) {
        this.idTruck = idTruck;
    }

    @Basic
    @Column(name = "Serial")
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Basic
    @Column(name = "Capacity")
    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Id
    @Column(name = "TruckState_idTruckState")
    public int getTruckStateIdTruckState() {
        return truckStateIdTruckState;
    }

    public void setTruckStateIdTruckState(int truckStateIdTruckState) {
        this.truckStateIdTruckState = truckStateIdTruckState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckEntity that = (TruckEntity) o;
        return idTruck == that.idTruck &&
                truckStateIdTruckState == that.truckStateIdTruckState &&
                Objects.equals(serial, that.serial) &&
                Objects.equals(capacity, that.capacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTruck, serial, capacity, truckStateIdTruckState);
    }
}
