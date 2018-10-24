package net.tsystems.springframe.services.objects;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RoadEntitySO {
    private int idRoad;
    private Double length;
    private Integer speedLimit;
    private CityEntitySO originCity;
    private CityEntitySO destinationCity;

    public int getIdRoad() {
        return idRoad;
    }

    public void setIdRoad(int idRoad) {
        this.idRoad = idRoad;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(Integer speedLimit) {
        this.speedLimit = speedLimit;
    }

    public CityEntitySO getOriginCity() {
        return originCity;
    }

    public void setOriginCity(CityEntitySO originCity) {
        this.originCity = originCity;
    }

    public CityEntitySO getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(CityEntitySO destinationCity) {
        this.destinationCity = destinationCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadEntitySO that = (RoadEntitySO) o;
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
