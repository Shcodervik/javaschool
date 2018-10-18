package net.tsystems.springframe.database;

import javax.persistence.*;

@Entity
@Table(name = "truck")
public class TruckEntity {
    private int idTruck;
    private String serial;
    private Double capacity;
    private TruckstateEntity truckStateIdTruckState;
    private int driversNumber;

    @Id
    @Column(name = "idTruck", nullable = false)
    public int getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(int idTruck) {
        this.idTruck = idTruck;
    }

    @Basic
    @Column(name = "Serial", nullable = true, length = 45)
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Basic
    @Column(name = "Capacity", nullable = true, precision = 0)
    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TruckEntity that = (TruckEntity) o;

        if (idTruck != that.idTruck) return false;
        if (serial != null ? !serial.equals(that.serial) : that.serial != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTruck;
        result = 31 * result + (serial != null ? serial.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "TruckState_idTruckState", referencedColumnName = "idTruckState", nullable = false)
    public TruckstateEntity getTruckStateIdTruckState() {
        return truckStateIdTruckState;
    }

    public void setTruckStateIdTruckState(TruckstateEntity truckStateIdTruckState) {
        this.truckStateIdTruckState = truckStateIdTruckState;
    }

    @Basic
    @Column(name = "DriversNumber", nullable = false)
    public int getDriversNumber() {
        return driversNumber;
    }

    public void setDriversNumber(int driversNumber) {
        this.driversNumber = driversNumber;
    }
}
