package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class TruckEntityPKSO {
    private int idTruck;
    private int truckStateIdTruckState;

    public int getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(int idTruck) {
        this.idTruck = idTruck;
    }

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
        TruckEntityPKSO that = (TruckEntityPKSO) o;
        return idTruck == that.idTruck &&
                truckStateIdTruckState == that.truckStateIdTruckState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTruck, truckStateIdTruckState);
    }
}
