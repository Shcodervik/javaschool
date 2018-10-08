package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.DriverstateEntity;

import java.util.List;

public interface DriverstateEntityDao {
    DriverstateEntity getDriverStateById(int idDriverState);
    List<DriverstateEntity> getAllDriverStates();
}
