package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class CargoEntityPKSO {
    private int idCargo;
    private int cargoStateIdCargoState;

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

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
        CargoEntityPKSO that = (CargoEntityPKSO) o;
        return idCargo == that.idCargo &&
                cargoStateIdCargoState == that.cargoStateIdCargoState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCargo, cargoStateIdCargoState);
    }
}
