/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.AbstractDao;
import net.tsystems.springframe.dao.CargoEntityDao;
import net.tsystems.springframe.dao.impl.AbstractDaoImpl;
import net.tsystems.springframe.dao.impl.CargoEntityDaoImpl;
import net.tsystems.springframe.database.CargoEntity;
import net.tsystems.springframe.services.mappers.CargoEntityMapper;
import net.tsystems.springframe.services.objects.CargoEntitySO;
import net.tsystems.springframe.services.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Component("cargoService")
public class CargoServiceImpl implements CargoService {

    private CargoEntityDao dao;

    @Autowired
    public void setDao(CargoEntityDao dao) {
        this.dao = dao;
    }


    @Override
    @Transactional
    public boolean addCargo(CargoEntitySO cargo) {
        if (cargo == null) {
            return false;
        }
        CargoEntity cargoEntity = CargoEntityMapper.INSTANCE.cargoDtoToEntity(cargo);
        ((AbstractDao)dao).create(cargoEntity);
        cargo.setIdCargo(cargoEntity.getIdCargo());
        return true;
    }

    @Override
    @Transactional
    public boolean updateCargo(CargoEntitySO cargo) {
        if (cargo == null) {
            return false;
        }
        CargoEntity cargoEntity = CargoEntityMapper.INSTANCE.cargoDtoToEntity(cargo);
        ((AbstractDao)dao).update(cargoEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteCargo(CargoEntitySO cargo) {
        if (cargo == null) {
            return false;
        }

        CargoEntity cargoEntity = CargoEntityMapper.INSTANCE.cargoDtoToEntity(cargo);
        ((AbstractDao)dao).delete(cargoEntity);
        return true;
    }

    @Override
    @Transactional
    public CargoEntitySO getCargoById(int id) {
        CargoEntitySO result = null;
        CargoEntity cargoEntity = (CargoEntity) ((AbstractDao)dao).getById(id);
        if (cargoEntity != null) {
            result = CargoEntityMapper.INSTANCE.cargoEntityToDto(cargoEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public List<CargoEntitySO> getAllCargoes() {
        final List<CargoEntitySO> result = new ArrayList<CargoEntitySO>();
        List<CargoEntity> cargoesEntity = dao.getAllCargo();
        if (CollectionUtils.isEmpty(cargoesEntity)) {
            return result;
        }
        for (CargoEntity data : cargoesEntity) {
            CargoEntitySO cargo = CargoEntityMapper.INSTANCE.cargoEntityToDto(data);
            result.add(cargo);
        }
        return result;
    }
}
