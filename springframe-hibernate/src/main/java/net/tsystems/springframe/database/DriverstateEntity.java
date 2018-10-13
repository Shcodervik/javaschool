package net.tsystems.springframe.database;

import javax.persistence.*;

@Entity
@Table(name = "driverstate")
public class DriverstateEntity {
    private int idDriverState;
    private String driverState;

    @Id
    @Column(name = "idDriverState", nullable = false)
    public int getIdDriverState() {
        return idDriverState;
    }

    public void setIdDriverState(int idDriverState) {
        this.idDriverState = idDriverState;
    }

    @Basic
    @Column(name = "DriverState", nullable = true, length = 45)
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

        DriverstateEntity that = (DriverstateEntity) o;

        if (idDriverState != that.idDriverState) return false;
        if (driverState != null ? !driverState.equals(that.driverState) : that.driverState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDriverState;
        result = 31 * result + (driverState != null ? driverState.hashCode() : 0);
        return result;
    }
}
