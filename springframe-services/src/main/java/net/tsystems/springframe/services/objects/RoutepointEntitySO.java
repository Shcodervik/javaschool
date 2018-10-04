package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class RoutepointEntitySO {
    private int idRoutePoint;
    private int routePointTypeIdRpType;
    private int orderIdOrder;
    private int cityIdCity;
    private int cargoIdCargo;
    private int cargoCargoStateIdCargoState;

    public int getIdRoutePoint() {
        return idRoutePoint;
    }

    public void setIdRoutePoint(int idRoutePoint) {
        this.idRoutePoint = idRoutePoint;
    }

    public int getRoutePointTypeIdRpType() {
        return routePointTypeIdRpType;
    }

    public void setRoutePointTypeIdRpType(int routePointTypeIdRpType) {
        this.routePointTypeIdRpType = routePointTypeIdRpType;
    }

    public int getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(int orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    public int getCityIdCity() {
        return cityIdCity;
    }

    public void setCityIdCity(int cityIdCity) {
        this.cityIdCity = cityIdCity;
    }

    public int getCargoIdCargo() {
        return cargoIdCargo;
    }

    public void setCargoIdCargo(int cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

    public int getCargoCargoStateIdCargoState() {
        return cargoCargoStateIdCargoState;
    }

    public void setCargoCargoStateIdCargoState(int cargoCargoStateIdCargoState) {
        this.cargoCargoStateIdCargoState = cargoCargoStateIdCargoState;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutepointEntitySO that = (RoutepointEntitySO) o;
        return idRoutePoint == that.idRoutePoint &&
                routePointTypeIdRpType == that.routePointTypeIdRpType &&
                orderIdOrder == that.orderIdOrder &&
                cityIdCity == that.cityIdCity &&
                cargoIdCargo == that.cargoIdCargo &&
                cargoCargoStateIdCargoState == that.cargoCargoStateIdCargoState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoutePoint, routePointTypeIdRpType, orderIdOrder, cityIdCity, cargoIdCargo, cargoCargoStateIdCargoState);
    }




}
