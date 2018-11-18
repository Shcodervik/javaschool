package net.tsystems.springframe.services.services;

import net.tsystems.springframe.services.objects.CityEntitySO;

import java.util.List;

public interface CityService {

    boolean addCity(CityEntitySO city);

    boolean updateCity(CityEntitySO city);

    boolean deleteCity(CityEntitySO city);

    CityEntitySO getCityById(int id);

    CityEntitySO getCityByName(String name);

    List<CityEntitySO> getAllCities();
}
