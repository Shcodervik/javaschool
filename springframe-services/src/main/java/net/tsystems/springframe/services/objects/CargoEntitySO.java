package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class CargoEntitySO {
    private int idCargo;
    private String description;
    private Double weight;
    private int cargoStateIdCargoState;

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
        CargoEntitySO that = (CargoEntitySO) o;
        return idCargo == that.idCargo &&
                cargoStateIdCargoState == that.cargoStateIdCargoState &&
                Objects.equals(description, that.description) &&
                Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
            return Objects.hash(idCargo, description, weight, cargoStateIdCargoState);
        }

}
