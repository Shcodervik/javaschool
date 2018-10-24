package net.tsystems.springframe.services.objects;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DriverstateEntitySO {
    private int idDriverState;
    private String driverState;

    public int getIdDriverState() {
        return idDriverState;
    }

    public void setIdDriverState(int idDriverState) {
        this.idDriverState = idDriverState;
    }

    public String getDriverState() {
        return driverState;
    }

    public void setDriverState(String driverState) {
        this.driverState = driverState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverstateEntitySO that = (DriverstateEntitySO) o;
        return idDriverState == that.idDriverState &&
                Objects.equals(driverState, that.driverState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriverState, driverState);
    }

}
