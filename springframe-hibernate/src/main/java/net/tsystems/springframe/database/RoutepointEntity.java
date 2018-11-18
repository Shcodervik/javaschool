package net.tsystems.springframe.database;

import javax.persistence.*;

@Entity
@Table(name = "routepoint")
public class RoutepointEntity {
    private int idRoutePoint;
    private CargoEntity cargoIdCargo;
    private CityEntity cityIdCity;
    private OrderEntity orderIdOrder;
    private RoutepointtypeEntity routePointTypeIdRpType;

    @Id
    @Column(name = "idRoutePoint", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdRoutePoint() {
        return idRoutePoint;
    }

    public void setIdRoutePoint(int idRoutePoint) {
        this.idRoutePoint = idRoutePoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutepointEntity that = (RoutepointEntity) o;

        if (idRoutePoint != that.idRoutePoint) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idRoutePoint;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "Cargo_idCargo", referencedColumnName = "idCargo", nullable = false)
    public CargoEntity getCargoIdCargo() {
        return cargoIdCargo;
    }

    public void setCargoIdCargo(CargoEntity cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "City_idCity", referencedColumnName = "idCity", nullable = false)
    public CityEntity getCityIdCity() {
        return cityIdCity;
    }

    public void setCityIdCity(CityEntity cityIdCity) {
        this.cityIdCity = cityIdCity;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "Order_idOrder", referencedColumnName = "idOrder", nullable = true)
    public OrderEntity getOrderIdOrder() {
        return orderIdOrder;
    }

    public void setOrderIdOrder(OrderEntity orderIdOrder) {
        this.orderIdOrder = orderIdOrder;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "RoutePointType_idRPType", referencedColumnName = "idRPType", nullable = false)
    public RoutepointtypeEntity getRoutePointTypeIdRpType() {
        return routePointTypeIdRpType;
    }

    public void setRoutePointTypeIdRpType(RoutepointtypeEntity routePointTypeIdRpType) {
        this.routePointTypeIdRpType = routePointTypeIdRpType;
    }
}
