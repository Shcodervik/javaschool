package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "truckstate", schema = "logiweb")
public class TruckstateEntity {
    private int idTruckState;
    private String truckState;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idTruckState")
    public int getIdTruckState() {
        return idTruckState;
    }

    public void setIdTruckState(int idTruckState) {
        this.idTruckState = idTruckState;
    }

    @Basic
    @Column(name = "TruckState")
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
        TruckstateEntity that = (TruckstateEntity) o;
        return idTruckState == that.idTruckState &&
                Objects.equals(truckState, that.truckState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTruckState, truckState);
    }
}
