package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.TruckEntity;

import java.util.List;

public interface TruckEntityDao {
    TruckEntity getTruckById(int idTruck);
    TruckEntity getTruckBySerial(String serial);
    List<TruckEntity> getAllTrucks();
    List<TruckEntity> getTrucksByCapacity(float capacity);
    List<TruckEntity> getTrucksByState(int idTruckState);
    List<TruckEntity> getTrucksByDriversNumber(int driversNumber);
}
