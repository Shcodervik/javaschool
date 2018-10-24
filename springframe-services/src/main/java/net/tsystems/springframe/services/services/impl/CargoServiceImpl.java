package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.impl.CargoEntityDaoImpl;
import net.tsystems.springframe.database.CargoEntity;
import net.tsystems.springframe.services.mappers.CargoEntityMapper;
import net.tsystems.springframe.services.objects.CargoEntitySO;
import net.tsystems.springframe.services.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoEntityDaoImpl dao;
    //private TruckstateEntityDaoImpl daoState;

    public CargoServiceImpl(){
        dao  = new CargoEntityDaoImpl();
    }


    @Override
    @Transactional
    public boolean addCargo(CargoEntitySO cargo) {
        if (cargo == null) {
            return false;
        }
        CargoEntity cargoEntity = CargoEntityMapper.INSTANCE.cargoDtoToEntity(cargo);
        dao.create(cargoEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateCargo(CargoEntitySO cargo) {
        if (cargo == null) {
            return false;
        }
        CargoEntity cargoEntity = CargoEntityMapper.INSTANCE.cargoDtoToEntity(cargo);
        dao.update(cargoEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteCargo(CargoEntitySO cargo) {
        if (cargo == null) {
            return false;
        }

        CargoEntity cargoEntity = CargoEntityMapper.INSTANCE.cargoDtoToEntity(cargo);
        dao.delete(cargoEntity);
        return true;
    }

    @Override
    @Transactional
    public CargoEntitySO getCargoById(int id) {
        CargoEntitySO result = null;
        CargoEntity cargoEntity = (CargoEntity) dao.getById(id);
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
            //LOG.error("NULL reference on users");
            return result;
        }
        for (CargoEntity data : cargoesEntity) {
            CargoEntitySO cargo = CargoEntityMapper.INSTANCE.cargoEntityToDto(data);
            result.add(cargo);
        }
        return result;
    }
}
