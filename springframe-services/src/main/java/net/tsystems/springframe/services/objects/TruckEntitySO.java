package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class TruckEntitySO {
    private int idTruck;
    private String serial;
    private Double capacity;
    private int truckStateIdTruckState;

    public int getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(int idTruck) {
        this.idTruck = idTruck;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
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
        TruckEntitySO that = (TruckEntitySO) o;
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
