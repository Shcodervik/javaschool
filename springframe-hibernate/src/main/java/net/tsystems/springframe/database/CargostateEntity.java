package net.tsystems.springframe.database;

import javax.persistence.*;

@Entity
@Table(name = "cargostate")
public class CargostateEntity {
    private int idCargoState;
    private String cargoState;

    @Id
    @Column(name = "idCargoState", nullable = false)
    public int getIdCargoState() {
        return idCargoState;
    }

    public void setIdCargoState(int idCargoState) {
        this.idCargoState = idCargoState;
    }

    @Basic
    @Column(name = "CargoState", nullable = true, length = 45)
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

        if (idCargoState != that.idCargoState) return false;
        if (cargoState != null ? !cargoState.equals(that.cargoState) : that.cargoState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCargoState;
        result = 31 * result + (cargoState != null ? cargoState.hashCode() : 0);
        return result;
    }
}
