package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.CityEntity;

import java.util.List;

public interface CityEntityDao {
    CityEntity getCityById(int idCity);
    List<CityEntity> getAllCities();
    void deleteAllCities();

}
