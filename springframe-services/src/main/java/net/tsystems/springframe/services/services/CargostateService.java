package net.tsystems.springframe.services.services;

import net.tsystems.springframe.services.objects.CargostateEntitySO;

import java.util.List;

public interface CargostateService {
    boolean addCargoState(CargostateEntitySO cargoState);

    boolean updateCargoState(CargostateEntitySO cargoState);

    boolean deleteCargoState(CargostateEntitySO cargoState);

    CargostateEntitySO getCargoStateById(int id);
    CargostateEntitySO getCargoStateByState(String state);

    List<CargostateEntitySO> getAllCargoStates();
}
