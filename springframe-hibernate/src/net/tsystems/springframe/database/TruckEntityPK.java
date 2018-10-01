package net.tsystems.springframe.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TruckEntityPK implements Serializable {
    private int idTruck;
    private int truckStateIdTruckState;

    @Column(name = "idTruck")
    @Id
    public int getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(int idTruck) {
        this.idTruck = idTruck;
    }

    @Column(name = "TruckState_idTruckState")
    @Id
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
        TruckEntityPK that = (TruckEntityPK) o;
        return idTruck == that.idTruck &&
                truckStateIdTruckState == that.truckStateIdTruckState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTruck, truckStateIdTruckState);
    }
}
