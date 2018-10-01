package net.tsystems.springframe.database;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "routepoint", schema = "logiweb")
@IdClass(RoutepointEntityPK.class)
public class RoutepointEntity {
    private int idRoutePoint;
    private int routePointTypeIdRpType;
    private int orderIdOrder;
    private int cityIdCity;
    private int cargoIdCargo;
    private int cargoCargoStateIdCargoState;

    @Id
    @Column(name = "idRoutePoint")
    public int getIdRoutePoint() {
        return idRoutePoint;
    }

    public void setIdRoutePoint(int idRoutePoint) {
        this.idRoutePoint = idRoutePoint;
    }

    @Id
    @Column(name = "RoutePointType_idRPType")
    public int getRoutePointTypeIdRpType() {
        return routePointTypeIdRpType;
    }

    public void setRoutePointTypeIdRpType(int routePointTypeIdRpType) {
        this.routePointTypeIdRpType = routePointTypeIdRpType;
    }

    @Id
    @Column(name = "Order_idOrder")
    public int getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(int orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    @Id
    @Column(name = "City_idCity")
    public int getCityIdCity() {
        return cityIdCity;
    }

    public void setCityIdCity(int cityIdCity) {
        this.cityIdCity = cityIdCity;
    }

    @Id
    @Column(name = "Cargo_idCargo")
    public int getCargoIdCargo() {
        return cargoIdCargo;
    }

    public void setCargoIdCargo(int cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

    @Id
    @Column(name = "Cargo_CargoState_idCargoState")
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
        RoutepointEntity that = (RoutepointEntity) o;
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
