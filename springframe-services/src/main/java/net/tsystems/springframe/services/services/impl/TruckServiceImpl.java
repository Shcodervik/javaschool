package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.AbstractDao;
import net.tsystems.springframe.dao.TruckEntityDao;
import net.tsystems.springframe.dao.impl.AbstractDaoImpl;
import net.tsystems.springframe.dao.impl.TruckEntityDaoImpl;
import net.tsystems.springframe.dao.impl.TruckstateEntityDaoImpl;
import net.tsystems.springframe.database.TruckEntity;
import net.tsystems.springframe.services.mappers.TruckEntityMapper;
import net.tsystems.springframe.services.objects.TruckEntitySO;
import net.tsystems.springframe.services.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component("truckService")
public class TruckServiceImpl implements TruckService {

    private TruckEntityDao dao;

    @Autowired
    public void setDao(TruckEntityDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public boolean addTruck(TruckEntitySO truck) {
        if (truck == null) {
            return false;
        }
        TruckEntity truckEntity = TruckEntityMapper.INSTANCE.truckDtoToEntity(truck);
        ((AbstractDao)dao).create(truckEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateTruck(TruckEntitySO truck) {
        if (truck == null) {
            return false;
        }
        TruckEntity truckEntity = TruckEntityMapper.INSTANCE.truckDtoToEntity(truck);
        ((AbstractDao)dao).update(truckEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteTruck(TruckEntitySO truck) {
        if (truck == null) {
            return false;
        }

        TruckEntity truckEntity = TruckEntityMapper.INSTANCE.truckDtoToEntity(truck);
        ((AbstractDao)dao).delete(truckEntity);
        return true;
    }

    @Override
    @Transactional
    public TruckEntitySO getTruckById(int id) {
        TruckEntitySO result = null;
        TruckEntity truckEntity = (TruckEntity) ((AbstractDao)dao).getById(id);
        if (truckEntity != null) {
            result = TruckEntityMapper.INSTANCE.truckEntityToDto(truckEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public TruckEntitySO getTruckBySerial(String serial) {
        TruckEntitySO result = null;
        TruckEntity truckEntity = (TruckEntity) dao.getTruckBySerial(serial);
        if (truckEntity != null) {
            result = TruckEntityMapper.INSTANCE.truckEntityToDto(truckEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public List<TruckEntitySO> getAllTrucks() {
        final List<TruckEntitySO> result = new ArrayList<TruckEntitySO>();
        List<TruckEntity> trucksEntity = dao.getAllTrucks();
        if (CollectionUtils.isEmpty(trucksEntity)) {
            //LOG.error("NULL reference on users");
            return result;
        }
        for (TruckEntity data : trucksEntity) {
            TruckEntitySO truck = TruckEntityMapper.INSTANCE.truckEntityToDto(data);
            result.add(truck);
        }
        return result;
    }
}
