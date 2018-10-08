package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.TruckstateEntity;

import java.util.List;

public interface TruckstateEntityDao {
    TruckstateEntity getTruckStateById(int idTruckState);
    List<TruckstateEntity> getAllTruckStates();
}
