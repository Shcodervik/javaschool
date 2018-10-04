package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class DriverworkinfoEntityPKSO {
    private int idDriverWorkInfo;
    private int driverIdDriver;
    private int driverStateIdDriverState;

    public int getIdDriverWorkInfo() {
        return idDriverWorkInfo;
    }

    public void setIdDriverWorkInfo(int idDriverWorkInfo) {
        this.idDriverWorkInfo = idDriverWorkInfo;
    }

    public int getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(int driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    public int getDriverStateIdDriverState() {
        return driverStateIdDriverState;
    }

    public void setDriverStateIdDriverState(int driverStateIdDriverState) {
        this.driverStateIdDriverState = driverStateIdDriverState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverworkinfoEntityPKSO that = (DriverworkinfoEntityPKSO) o;
        return idDriverWorkInfo == that.idDriverWorkInfo &&
                driverIdDriver == that.driverIdDriver &&
                driverStateIdDriverState == that.driverStateIdDriverState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriverWorkInfo, driverIdDriver, driverStateIdDriverState);
    }
}
