package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cargo", schema = "logiweb")
@IdClass(CargoEntityPK.class)
public class CargoEntity {
    private int idCargo;
    private String description;
    private Double weight;
    private int cargoStateIdCargoState;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idCargo")
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Weight")
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Id
    @Column(name = "CargoState_idCargoState")
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
        CargoEntity that = (CargoEntity) o;
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
