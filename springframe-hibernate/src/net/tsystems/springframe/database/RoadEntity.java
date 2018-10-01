package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "road", schema = "logiweb")
public class RoadEntity {
    private int idRoad;
    private Double length;
    private Integer speedLimit;
    private String originCity;
    private String destinationCity;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idRoad")
    public int getIdRoad() {
        return idRoad;
    }

    public void setIdRoad(int idRoad) {
        this.idRoad = idRoad;
    }

    @Basic
    @Column(name = "Length")
    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    @Basic
    @Column(name = "SpeedLimit")
    public Integer getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Basic
    @Column(name = "OriginCity")
    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    @Basic
    @Column(name = "DestinationCity")
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
        return idRoad == that.idRoad &&
                Objects.equals(length, that.length) &&
                Objects.equals(speedLimit, that.speedLimit) &&
                Objects.equals(originCity, that.originCity) &&
                Objects.equals(destinationCity, that.destinationCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoad, length, speedLimit, originCity, destinationCity);
    }
}
