package net.tsystems.springframe.database;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "driverworkinfo", schema = "logiweb")
@IdClass(DriverworkinfoEntityPK.class)
public class DriverworkinfoEntity {
    private int idDriverWorkInfo;
    private Date startDt;
    private Date stopDt;
    private int driverIdDriver;
    private int driverStateIdDriverState;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idDriverWorkInfo")
    public int getIdDriverWorkInfo() {
        return idDriverWorkInfo;
    }

    public void setIdDriverWorkInfo(int idDriverWorkInfo) {
        this.idDriverWorkInfo = idDriverWorkInfo;
    }

    @Basic
    @Column(name = "StartDT")
    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    @Basic
    @Column(name = "StopDT")
    public Date getStopDt() {
        return stopDt;
    }

    public void setStopDt(Date stopDt) {
        this.stopDt = stopDt;
    }

    @Id
    @Column(name = "Driver_idDriver")
    public int getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(int driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    @Id
    @Column(name = "DriverState_idDriverState")
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
        DriverworkinfoEntity that = (DriverworkinfoEntity) o;
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
