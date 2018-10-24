package net.tsystems.springframe.database;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "driverworkinfo")
public class DriverworkinfoEntity {
    private int idDriverWorkInfo;
    private Date startDt;
    private Date stopDt;
    private DriverEntity driverIdDriver;
    private DriverstateEntity driverStateIdDriverState;

    @Id
    @Column(name = "idDriverWorkInfo", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdDriverWorkInfo() {
        return idDriverWorkInfo;
    }

    public void setIdDriverWorkInfo(int idDriverWorkInfo) {
        this.idDriverWorkInfo = idDriverWorkInfo;
    }

    @Basic
    @Column(name = "StartDT", nullable = true)
    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    @Basic
    @Column(name = "StopDT", nullable = true)
    public Date getStopDt() {
        return stopDt;
    }

    public void setStopDt(Date stopDt) {
        this.stopDt = stopDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverworkinfoEntity that = (DriverworkinfoEntity) o;

        if (idDriverWorkInfo != that.idDriverWorkInfo) return false;
        if (startDt != null ? !startDt.equals(that.startDt) : that.startDt != null) return false;
        if (stopDt != null ? !stopDt.equals(that.stopDt) : that.stopDt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDriverWorkInfo;
        result = 31 * result + (startDt != null ? startDt.hashCode() : 0);
        result = 31 * result + (stopDt != null ? stopDt.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "Driver_idDriver", referencedColumnName = "idDriver", nullable = false)
    public DriverEntity getDriverIdDriver() {
        return driverIdDriver;
    }

    public void setDriverIdDriver(DriverEntity driverIdDriver) {
        this.driverIdDriver = driverIdDriver;
    }

    @OneToOne
    @JoinColumn(name = "DriverState_idDriverState", referencedColumnName = "idDriverState", nullable = false)
    public DriverstateEntity getDriverStateIdDriverState() {
        return driverStateIdDriverState;
    }

    public void setDriverStateIdDriverState(DriverstateEntity driverStateIdDriverState) {
        this.driverStateIdDriverState = driverStateIdDriverState;
    }
}
