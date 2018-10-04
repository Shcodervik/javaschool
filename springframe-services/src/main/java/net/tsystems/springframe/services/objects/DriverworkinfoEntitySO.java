package net.tsystems.springframe.services.objects;

import java.sql.Date;
import java.util.Objects;

public class DriverworkinfoEntitySO {
    private int idDriverWorkInfo;
    private Date startDt;
    private Date stopDt;
    private int driverIdDriver;
    private int driverStateIdDriverState;

    public int getIdDriverWorkInfo() {
        return idDriverWorkInfo;
    }

    public void setIdDriverWorkInfo(int idDriverWorkInfo) {
        this.idDriverWorkInfo = idDriverWorkInfo;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getStopDt() {
        return stopDt;
    }

    public void setStopDt(Date stopDt) {
        this.stopDt = stopDt;
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
        DriverworkinfoEntitySO that = (DriverworkinfoEntitySO) o;
        return idDriverWorkInfo == that.idDriverWorkInfo &&
                driverIdDriver == that.driverIdDriver &&
                driverStateIdDriverState == that.driverStateIdDriverState &&
                Objects.equals(startDt, that.startDt) &&
                Objects.equals(stopDt, that.stopDt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriverWorkInfo, startDt, stopDt, driverIdDriver, driverStateIdDriverState);
    }
}
