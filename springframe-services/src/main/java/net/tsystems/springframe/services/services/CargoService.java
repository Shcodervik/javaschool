package net.tsystems.springframe.services.services;

import net.tsystems.springframe.services.objects.CargoEntitySO;

import java.util.List;

public interface CargoService {

    boolean addCargo(CargoEntitySO cargo);

    boolean updateCargo(CargoEntitySO cargo);

    boolean deleteCargo(CargoEntitySO cargo);

    CargoEntitySO getCargoById(int id);

    List<CargoEntitySO> getAllCargoes();

}
