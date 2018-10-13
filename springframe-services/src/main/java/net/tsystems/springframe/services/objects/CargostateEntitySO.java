package net.tsystems.springframe.services.objects;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CargostateEntitySO {
    private int idCargoState;
    private String cargoState;

    public int getIdCargoState() {
        return idCargoState;
    }

    public void setIdCargoState(int idCargoState) {
        this.idCargoState = idCargoState;
    }

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
        CargostateEntitySO that = (CargostateEntitySO) o;
        return idCargoState == that.idCargoState &&
                Objects.equals(cargoState, that.cargoState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCargoState, cargoState);
    }
}
