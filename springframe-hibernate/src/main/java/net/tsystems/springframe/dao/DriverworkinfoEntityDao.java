package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.DriverworkinfoEntity;

import java.util.List;

public interface DriverworkinfoEntityDao {
    DriverworkinfoEntity getDriverWorkInfoById(int idDriverWorkInfo);
    List<DriverworkinfoEntity> getAllDriverWorkInfo();
    List<DriverworkinfoEntity> getAllDriverWorkInfoByIdDriver(int idDriver);

}
