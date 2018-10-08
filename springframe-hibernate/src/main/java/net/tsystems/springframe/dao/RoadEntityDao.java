package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.RoadEntity;

import java.util.List;

public interface RoadEntityDao {
    RoadEntity getRoadById(int idRoad);
    List<RoadEntity> getAllRoads();
    List<RoadEntity> getAllRoadsByOriginCity();
    List<RoadEntity> getAllRoadsByDestinationCity();

}
