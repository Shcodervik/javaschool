package net.tsystems.springframe.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CargoEntityPK implements Serializable {
    private int idCargo;
    private int cargoStateIdCargoState;

    @Column(name = "idCargo")
    @Id
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    @Column(name = "CargoState_idCargoState")
    @Id
    public int getCargoStateIdCargoState() {
        return cargoStateIdCargoState;
    }

    public void setCargoStateIdCargoState(int cargoStateIdCargoState) {
        this.cargoStateIdCargoState = cargoStateIdCargoState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoEntityPK that = (CargoEntityPK) o;
        return idCargo == that.idCargo &&
                cargoStateIdCargoState == that.cargoStateIdCargoState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCargo, cargoStateIdCargoState);
    }
}
