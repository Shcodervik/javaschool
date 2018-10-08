package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.CargostateEntity;

import java.util.List;

public interface CargostateEntityDao {
    CargostateEntity getCargoStateById(int idCargoState);
    List<CargostateEntity> getAllCargoStates();
}
