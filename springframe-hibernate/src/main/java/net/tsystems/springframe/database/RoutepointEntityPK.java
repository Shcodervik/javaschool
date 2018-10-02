package net.tsystems.springframe.database;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RoutepointEntityPK implements Serializable {
    private int idRoutePoint;
    private int routePointTypeIdRpType;
    private int orderIdOrder;
    private int cityIdCity;
    private int cargoIdCargo;
    private int cargoCargoStateIdCargoState;

    @Column(name = "idRoutePoint")
    @Id
    public int getIdRoutePoint() {
        return idRoutePoint;
    }

    public void setIdRoutePoint(int idRoutePoint) {
        this.idRoutePoint = idRoutePoint;
    }

    @Column(name = "RoutePointType_idRPType")
    @Id
    public int getRoutePointTypeIdRpType() {
        return routePointTypeIdRpType;
    }

    public void setRoutePointTypeIdRpType(int routePointTypeIdRpType) {
        this.routePointTypeIdRpType = routePointTypeIdRpType;
    }

    @Column(name = "Order_idOrder")
    @Id
    public int getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(int orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    @Column(name = "City_idCity")
    @Id
    public int getCityIdCity() {
        return cityIdCity;
    }

    public void setCityIdCity(int cityIdCity) {
        this.cityIdCity = cityIdCity;
    }

    @Column(name = "Cargo_idCargo")
    @Id
    public int getCargoIdCargo() {
        return cargoIdCargo;
    }

    public void setCargoIdCargo(int cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

    @Column(name = "Cargo_CargoState_idCargoState")
    @Id
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
        RoutepointEntityPK that = (RoutepointEntityPK) o;
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
