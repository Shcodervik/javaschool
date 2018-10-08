package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.RoutepointEntity;

import java.util.List;

public interface RoutepointEntityDao {
    RoutepointEntity getRoutepointById(int idOrder);
    List<RoutepointEntity> getAllRoutepoints();
}
