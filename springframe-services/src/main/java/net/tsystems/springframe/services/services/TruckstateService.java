package net.tsystems.springframe.services.services;

import net.tsystems.springframe.services.objects.TruckstateEntitySO;

import java.util.List;

public interface TruckstateService {
    boolean addTruckState(TruckstateEntitySO truckState);

    boolean updateTruckState(TruckstateEntitySO truckState);

    boolean deleteTruckState(TruckstateEntitySO truckState);

    TruckstateEntitySO getTruckStateById(int id);
    TruckstateEntitySO getTruckStateByState(String state);

    List<TruckstateEntitySO> getAllTruckStates();
}
