package net.tsystems.springframe.services.objects;

import java.util.Objects;

public class RoutepointEntitySO {
    private int idRoutePoint;
    private RoutepointtypeEntitySO routePointTypeIdRpType;
    private OrderEntitySO orderIdOrder;
    private CityEntitySO cityIdCity;
    private CargoEntitySO cargoIdCargo;

    public int getIdRoutePoint() {
        return idRoutePoint;
    }

    public void setIdRoutePoint(int idRoutePoint) {
        this.idRoutePoint = idRoutePoint;
    }

    public RoutepointtypeEntitySO getRoutePointTypeIdRpType() {
        return routePointTypeIdRpType;
    }

    public void setRoutePointTypeIdRpType(RoutepointtypeEntitySO routePointTypeIdRpType) {
        this.routePointTypeIdRpType = routePointTypeIdRpType;
    }

    public OrderEntitySO getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(OrderEntitySO orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    public CityEntitySO getCityIdCity() {
        return cityIdCity;
    }

    public void setCityIdCity(CityEntitySO cityIdCity) {
        this.cityIdCity = cityIdCity;
    }

    public CargoEntitySO getCargoIdCargo() {
        return cargoIdCargo;
    }

    public void setCargoIdCargo(CargoEntitySO cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutepointEntitySO that = (RoutepointEntitySO) o;
        return idRoutePoint == that.idRoutePoint &&
                Objects.equals(routePointTypeIdRpType, that.routePointTypeIdRpType) &&
                Objects.equals(orderIdOrder, that.orderIdOrder) &&
                Objects.equals(cityIdCity, that.cityIdCity) &&
                Objects.equals(cargoIdCargo, that.cargoIdCargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRoutePoint, routePointTypeIdRpType, orderIdOrder, cityIdCity, cargoIdCargo);
    }
}
