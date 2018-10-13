package net.tsystems.springframe.database;

import javax.persistence.*;

@Entity
@Table(name = "road")
public class RoadEntity {
    private int idRoad;
    private Double length;
    private Integer speedLimit;
    private String originCity;
    private String destinationCity;

    @Id
    @Column(name = "idRoad", nullable = false)
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

    @Basic
    @Column(name = "OriginCity", nullable = true, length = 45)
    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    @Basic
    @Column(name = "DestinationCity", nullable = true, length = 45)
    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoadEntity that = (RoadEntity) o;

        if (idRoad != that.idRoad) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (speedLimit != null ? !speedLimit.equals(that.speedLimit) : that.speedLimit != null) return false;
        if (originCity != null ? !originCity.equals(that.originCity) : that.originCity != null) return false;
        if (destinationCity != null ? !destinationCity.equals(that.destinationCity) : that.destinationCity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoad;
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (speedLimit != null ? speedLimit.hashCode() : 0);
        result = 31 * result + (originCity != null ? originCity.hashCode() : 0);
        result = 31 * result + (destinationCity != null ? destinationCity.hashCode() : 0);
        return result;
    }
}
