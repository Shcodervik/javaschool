package net.tsystems.springframe.services.services;

import net.tsystems.springframe.services.objects.DriverEntitySO;

import java.util.List;

public interface DriverService {
    boolean addDriver(DriverEntitySO driver);

    boolean updateDriver(DriverEntitySO driver);

    boolean deleteDriver(DriverEntitySO driver);

    DriverEntitySO getDriverById(int id);

    DriverEntitySO getDriverByUIN(String uin);

    List<DriverEntitySO> getAllDrivers();

    List<DriverEntitySO> getDriversForOrder();
}
