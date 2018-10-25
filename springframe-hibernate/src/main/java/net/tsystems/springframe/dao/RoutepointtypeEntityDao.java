package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.RoutepointtypeEntity;

import java.util.List;

public interface RoutepointtypeEntityDao {
    RoutepointtypeEntity getRoutePointTypeById(int idRoutePointType);
    List<RoutepointtypeEntity> getAllRoutePointTypes();
}
