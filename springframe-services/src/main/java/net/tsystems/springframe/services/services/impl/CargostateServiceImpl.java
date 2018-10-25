package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.impl.CargostateEntityDaoImpl;
import net.tsystems.springframe.database.CargostateEntity;
import net.tsystems.springframe.services.mappers.CargostateEntityMapper;
import net.tsystems.springframe.services.objects.CargostateEntitySO;
import net.tsystems.springframe.services.services.CargostateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Component("cargoStateService")
public class CargostateServiceImpl implements CargostateService {
    @Autowired
    private CargostateEntityDaoImpl dao;

    public CargostateServiceImpl(){
        dao  = new CargostateEntityDaoImpl();
    }

    @Override
    public boolean addCargoState(CargostateEntitySO cargoState) {
        if (cargoState == null) {
            return false;
        }
        CargostateEntity cargostateEntity = CargostateEntityMapper.INSTANCE.cargostateDtoToEntity(cargoState);
        dao.create(cargostateEntity);
        return true;
    }

    @Override
    public boolean updateCargoState(CargostateEntitySO cargoState) {
        if (cargoState == null) {
            return false;
        }
        CargostateEntity cargostateEntity = CargostateEntityMapper.INSTANCE.cargostateDtoToEntity(cargoState);
        dao.update(cargostateEntity);
        return true;
    }

    @Override
    public boolean deleteCargoState(CargostateEntitySO cargoState) {
        if (cargoState == null) {
            return false;
        }

        CargostateEntity cargostateEntity = CargostateEntityMapper.INSTANCE.cargostateDtoToEntity(cargoState);
        dao.delete(cargostateEntity);
        return true;
    }

    @Override
    public CargostateEntitySO getCargoStateById(int id) {
        CargostateEntitySO result = null;
        CargostateEntity cargostateEntity = (CargostateEntity) dao.getById(id);
        if (cargostateEntity != null) {
            result = CargostateEntityMapper.INSTANCE.cargostateEntityToDto(cargostateEntity);
        }
        return result;
    }

    @Override
    public CargostateEntitySO getCargoStateByState(String state) {
        CargostateEntitySO result = null;
        CargostateEntity cargostateEntity = (CargostateEntity) dao.getCargoStateByState(state);
        if (cargostateEntity != null) {
            result = CargostateEntityMapper.INSTANCE.cargostateEntityToDto(cargostateEntity);
        }
        return result;
    }

    @Override
    public List<CargostateEntitySO> getAllCargoStates() {
        final List<CargostateEntitySO> result = new ArrayList<CargostateEntitySO>();
        List<CargostateEntity> truckstatesEntity = dao.getAllCargoStates();
        if (CollectionUtils.isEmpty(truckstatesEntity)) {
            //LOG.error("NULL reference on users");
            return result;
        }
        for (CargostateEntity data : truckstatesEntity) {
            CargostateEntitySO truck = CargostateEntityMapper.INSTANCE.cargostateEntityToDto(data);
            result.add(truck);
        }
        return result;
    }
}
