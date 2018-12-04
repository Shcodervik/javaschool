package net.tsystems.springframe.services.services;

import net.tsystems.springframe.services.objects.TruckEntitySO;

import java.util.List;

public interface TruckService {
    boolean addTruck(TruckEntitySO truck);

    boolean updateTruck(TruckEntitySO truck);

    boolean deleteTruck(TruckEntitySO truck);

    TruckEntitySO getTruckById(int id);

    TruckEntitySO getTruckBySerial(String serial);

    List<TruckEntitySO> getTrucksForOrder(Double capacity);

    List<TruckEntitySO> getAllTrucks();
}
