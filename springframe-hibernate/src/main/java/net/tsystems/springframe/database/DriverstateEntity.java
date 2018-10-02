package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "driverstate", schema = "logiweb")
public class DriverstateEntity {
    private int idDriverState;
    private String driverState;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idDriverState")
    public int getIdDriverState() {
        return idDriverState;
    }

    public void setIdDriverState(int idDriverState) {
        this.idDriverState = idDriverState;
    }

    @Basic
    @Column(name = "DriverState")
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
        return idDriverState == that.idDriverState &&
                Objects.equals(driverState, that.driverState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDriverState, driverState);
    }
}
