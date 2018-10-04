package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.CargoEntity;

import java.util.List;

public interface CargoEntityDao {
    CargoEntity getCargoById(int idCargo);
    List<CargoEntity> getAllCargo();
    List<CargoEntity> getAllCargoByState(String state);
}
