package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.DriverworkinfoEntity;

import java.util.List;

public interface DriverworkinfoEntityDao {
    DriverworkinfoEntity getDriverworkinfoById(int idDriverworkinfo);
    List<DriverworkinfoEntity> getAllDriverworkinfo();
    List<DriverworkinfoEntity> getAllDriverworkinfoByIdDriver(int idDriver);

}
