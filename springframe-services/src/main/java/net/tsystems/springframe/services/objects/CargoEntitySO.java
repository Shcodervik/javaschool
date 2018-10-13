package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class CargoEntitySO {
    private int idCargo;
    private String description;
    private Double weight;
    private CargostateEntitySO cargoStateIdCargoState;

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public CargostateEntitySO getCargoStateIdCargoState() {
        return cargoStateIdCargoState;
    }

    public void setCargoStateIdCargoState(CargostateEntitySO idCargoState) {
        cargoStateIdCargoState = idCargoState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoEntitySO that = (CargoEntitySO) o;
        return idCargo == that.idCargo &&
                Objects.equals(description, that.description) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(cargoStateIdCargoState, that.cargoStateIdCargoState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCargo, description, weight, cargoStateIdCargoState);
    }
}
