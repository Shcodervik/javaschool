package net.tsystems.springframe.database;

import javax.persistence.*;

@Entity
@Table(name = "road")
public class RoadEntity {
    private int idRoad;
    private Double length;
    private Integer speedLimit;
    private CityEntity destinationCity;
    private CityEntity originCity;

    @Id
    @Column(name = "idRoad", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdRoad() {
        return idRoad;
    }

    public void setIdRoad(int idRoad) {
        this.idRoad = idRoad;
    }

    @Basic
    @Column(name = "Length", nullable = true, precision = 0)
    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    @Basic
    @Column(name = "SpeedLimit", nullable = true)
    public Integer getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoadEntity that = (RoadEntity) o;

        if (idRoad != that.idRoad) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (speedLimit != null ? !speedLimit.equals(that.speedLimit) : that.speedLimit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoad;
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (speedLimit != null ? speedLimit.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "DestinationCity", referencedColumnName = "idCity", nullable = false)
    public CityEntity getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(CityEntity destinationCity) {
        this.destinationCity = destinationCity;
    }

    @OneToOne
    @JoinColumn(name = "OriginCity", referencedColumnName = "idCity", nullable = false)
    public CityEntity getOriginCity() {
        return originCity;
    }

    public void setOriginCity(CityEntity originCity) {
        this.originCity = originCity;
    }
}
