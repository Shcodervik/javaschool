package net.tsystems.springframe.services.objects;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Objects;

@Service
public class DriverworkinfoEntitySO {
    private int idDriverWorkInfo;
    private Date startDt;
    private Date stopDt;
    private DriverEntitySO driverIdDriver;
    private DriverstateEntitySO driverStateIdDriverState;

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

    public DriverEntitySO getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(DriverEntitySO driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    public DriverstateEntitySO getDriverStateIdDriverState() {
        return driverStateIdDriverState;
    }

    public void setDriverStateIdDriverState(DriverstateEntitySO driverStateIdDriverState) {
        this.driverStateIdDriverState = driverStateIdDriverState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DriverworkinfoEntitySO that = (DriverworkinfoEntitySO) o;
        return idDriverWorkInfo == that.idDriverWorkInfo &&
                Objects.equals(startDt, that.startDt) &&
                Objects.equals(stopDt, that.stopDt) &&
                Objects.equals(driverIdDriver, that.driverIdDriver) &&
                Objects.equals(driverStateIdDriverState, that.driverStateIdDriverState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriverWorkInfo, startDt, stopDt, driverIdDriver, driverStateIdDriverState);
    }
}
