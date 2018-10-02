package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cargostate", schema = "logiweb")
public class CargostateEntity {
    private int idCargoState;
    private String cargoState;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idCargoState")
    public int getIdCargoState() {
        return idCargoState;
    }

    public void setIdCargoState(int idCargoState) {
        this.idCargoState = idCargoState;
    }

    @Basic
    @Column(name = "CargoState")
    public String getCargoState() {
        return cargoState;
    }

    public void setCargoState(String cargoState) {
        this.cargoState = cargoState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargostateEntity that = (CargostateEntity) o;
        return idCargoState == that.idCargoState &&
                Objects.equals(cargoState, that.cargoState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCargoState, cargoState);
    }
}
