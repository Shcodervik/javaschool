package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.RoutepointtypeEntity;

import java.util.List;

public interface RoutepointtypeEntityDao {
    RoutepointtypeEntity getRoutePointTypeById(int idRoutePointType);
    RoutepointtypeEntity getRoutePointTypeByType(String routePointType);
    List<RoutepointtypeEntity> getAllRoutePointTypes();

}
