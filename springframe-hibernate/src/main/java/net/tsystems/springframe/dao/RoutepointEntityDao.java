package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.RoutepointEntity;

import java.util.List;

public interface RoutepointEntityDao {
    RoutepointEntity getRoutePointById(int idRoutePoint);
    List<RoutepointEntity> getAllRoutePoints();
}
