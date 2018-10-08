package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.CargostateEntity;

import java.util.List;

public interface CargostateEntityDao {
    CargostateEntity getCargostateById(int idCargostate);
    List<CargostateEntity> getAllCargostates();
}
