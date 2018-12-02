package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.CargoEntity;
import net.tsystems.springframe.database.OrderEntity;
import net.tsystems.springframe.database.RoutepointEntity;

import java.util.List;

public interface RoutepointEntityDao {
    RoutepointEntity getRoutePointById(int idRoutePoint);
    List<RoutepointEntity> getRoutePointsByType(int idRPType);
    List<RoutepointEntity> getRoutePointsByCargo(CargoEntity cargo);
    List<RoutepointEntity> getAllRoutePoints();
    List<RoutepointEntity> getRoutePointsByOrder(OrderEntity order);
}
