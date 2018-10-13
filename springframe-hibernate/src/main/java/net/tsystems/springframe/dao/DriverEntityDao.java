package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.DriverEntity;

import java.util.List;

public interface DriverEntityDao {
    DriverEntity getDriverById(int idDriver);
    List<DriverEntity> getDriversByName(String name);
    List<DriverEntity> getDriversBySurname(String surname);
    List<DriverEntity> getAllDrivers();
    /*
    * TODO: driverState from Driverworkinfo. Just int? or what?
    * */

    List<DriverEntity> getAllDriversByState(int driverState);
}
