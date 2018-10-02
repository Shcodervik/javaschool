package net.tsystems.springframe.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class DriverworkinfoEntityPK implements Serializable {
    private int idDriverWorkInfo;
    private int driverIdDriver;
    private int driverStateIdDriverState;

    @Column(name = "idDriverWorkInfo")
    @Id
    public int getIdDriverWorkInfo() {
        return idDriverWorkInfo;
    }

    public void setIdDriverWorkInfo(int idDriverWorkInfo) {
        this.idDriverWorkInfo = idDriverWorkInfo;
    }

    @Column(name = "Driver_idDriver")
    @Id
    public int getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(int driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    @Column(name = "DriverState_idDriverState")
    @Id
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
        DriverworkinfoEntityPK that = (DriverworkinfoEntityPK) o;
        return idDriverWorkInfo == that.idDriverWorkInfo &&
                driverIdDriver == that.driverIdDriver &&
                driverStateIdDriverState == that.driverStateIdDriverState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriverWorkInfo, driverIdDriver, driverStateIdDriverState);
    }
}
