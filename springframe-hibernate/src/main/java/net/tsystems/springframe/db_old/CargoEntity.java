package net.tsystems.springframe.db_old;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class CargoEntity {
    private int idCargo;
    private String description;
    private Double weight;
    private CargostateEntity cargoStateIdCargoState;

    @Id
    @Column(name = "idCargo", nullable = false)
    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Weight", nullable = true, precision = 0)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CargoEntity that = (CargoEntity) o;

        if (idCargo != that.idCargo) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCargo;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "CargoState_idCargoState", referencedColumnName = "idCargoState", nullable = false)
    public CargostateEntity getCargoStateIdCargoState() {
        return cargoStateIdCargoState;
    }

    public void setCargoStateIdCargoState(CargostateEntity cargoStateIdCargoState) {
        this.cargoStateIdCargoState = cargoStateIdCargoState;
    }
}
