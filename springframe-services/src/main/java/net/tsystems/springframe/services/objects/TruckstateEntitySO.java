package net.tsystems.springframe.services.objects;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TruckstateEntitySO {
    private int idTruckState;
    private String truckState;

    public int getIdTruckState() {
        return idTruckState;
    }

    public void setIdTruckState(int idTruckState) {
        this.idTruckState = idTruckState;
    }

    public String getTruckState() {
        return truckState;
    }

    public void setTruckState(String truckState) {
        this.truckState = truckState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TruckstateEntitySO that = (TruckstateEntitySO) o;
        return idTruckState == that.idTruckState &&
                Objects.equals(truckState, that.truckState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTruckState, truckState);
    }
}
