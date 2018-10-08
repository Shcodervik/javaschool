package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.RoutepointtypeEntity;

import java.util.List;

public interface RoutepointtypeEntityDao {
    RoutepointtypeEntity getRoutepointtypeById(int idOrder);
    List<RoutepointtypeEntity> getAllRoutepointtypes();
}
