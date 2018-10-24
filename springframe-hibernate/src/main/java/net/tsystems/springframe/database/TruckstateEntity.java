package net.tsystems.springframe.database;

import javax.persistence.*;

@Entity
@Table(name = "truckstate")
public class TruckstateEntity {
    private int idTruckState;
    private String truckState;

    @Id
    @Column(name = "idTruckState", nullable = false)
    public int getIdTruckState() {
        return idTruckState;
    }

    public void setIdTruckState(int idTruckState) {
        this.idTruckState = idTruckState;
    }

    @Basic
    @Column(name = "TruckState", nullable = true, length = 45)
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

        if (idTruckState != that.idTruckState) return false;
        if (truckState != null ? !truckState.equals(that.truckState) : that.truckState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTruckState;
        result = 31 * result + (truckState != null ? truckState.hashCode() : 0);
        return result;
    }
}
