package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.impl.TruckstateEntityDaoImpl;
import net.tsystems.springframe.database.TruckstateEntity;
import net.tsystems.springframe.services.mappers.TruckstateEntityMapper;
import net.tsystems.springframe.services.objects.TruckstateEntitySO;
import net.tsystems.springframe.services.services.TruckstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component("truckStateService")
public class TruckstateServiceImpl implements TruckstateService {

    @Autowired
    private TruckstateEntityDaoImpl dao;

    @Autowired
    public void setDao(TruckstateEntityDaoImpl dao) {
        this.dao = dao;
    }

    //public TruckstateServiceImpl(){
   //     dao  = new TruckstateEntityDaoImpl();
   // }

    @Override
    @Transactional
    public boolean addTruckState(TruckstateEntitySO truckState) {
        if (truckState == null) {
            return false;
        }
        TruckstateEntity truckstateEntity = TruckstateEntityMapper.INSTANCE.truckstateDtoToEntity(truckState);
        dao.create(truckstateEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateTruckState(TruckstateEntitySO truckState) {
        if (truckState == null) {
            return false;
        }
        TruckstateEntity truckstateEntity = TruckstateEntityMapper.INSTANCE.truckstateDtoToEntity(truckState);
        dao.update(truckstateEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteTruckState(TruckstateEntitySO truckState) {
            if (truckState == null) {
                return false;
            }

            TruckstateEntity truckstateEntity = TruckstateEntityMapper.INSTANCE.truckstateDtoToEntity(truckState);
            dao.delete(truckstateEntity);
            return true;
    }

    @Override
    @Transactional
    public TruckstateEntitySO getTruckStateById(int id) {
        TruckstateEntitySO result = null;
        TruckstateEntity truckstateEntity = (TruckstateEntity) dao.getById(id);
        if (truckstateEntity != null) {
            result = TruckstateEntityMapper.INSTANCE.truckstateEntityToDto(truckstateEntity);
        }
        return result;
    }

    @Override
    public TruckstateEntitySO getTruckStateByState(String state) {
        TruckstateEntitySO result = null;
        TruckstateEntity truckstateEntity = (TruckstateEntity) dao.getTruckStateByState(state);
        if (truckstateEntity != null) {
            result = TruckstateEntityMapper.INSTANCE.truckstateEntityToDto(truckstateEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public List<TruckstateEntitySO> getAllTruckStates() {
        final List<TruckstateEntitySO> result = new ArrayList<TruckstateEntitySO>();
        List<TruckstateEntity> truckstatesEntity = dao.getAllTruckStates();
        if (CollectionUtils.isEmpty(truckstatesEntity)) {
            //LOG.error("NULL reference on users");
            return result;
        }
        for (TruckstateEntity data : truckstatesEntity) {
            TruckstateEntitySO truck = TruckstateEntityMapper.INSTANCE.truckstateEntityToDto(data);
            result.add(truck);
        }
        return result;
    }
}
