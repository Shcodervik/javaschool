package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.impl.DriverEntityDaoImpl;
import net.tsystems.springframe.database.DriverEntity;
import net.tsystems.springframe.services.mappers.DriverEntityMapper;
import net.tsystems.springframe.services.objects.DriverEntitySO;
import net.tsystems.springframe.services.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverEntityDaoImpl dao;

    public DriverServiceImpl(){
        dao  = new DriverEntityDaoImpl();
    }

    @Override
    @Transactional
    public boolean addDriver(DriverEntitySO driver) {
        if (driver == null) {
            return false;
        }
        DriverEntity driverEntity = DriverEntityMapper.INSTANCE.driverDtoToEntity(driver);
        dao.create(driverEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateDriver(DriverEntitySO driver) {
        if (driver == null) {
            return false;
        }
        DriverEntity driverEntity = DriverEntityMapper.INSTANCE.driverDtoToEntity(driver);
        dao.update(driverEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteDriver(DriverEntitySO driver) {
        if (driver == null) {
            return false;
        }

        DriverEntity driverEntity = DriverEntityMapper.INSTANCE.driverDtoToEntity(driver);
        dao.delete(driverEntity);
        return true;
    }

    @Override
    @Transactional
    public DriverEntitySO getDriverById(int id) {
        DriverEntitySO result = null;
        DriverEntity driverEntity = (DriverEntity) dao.getById(id);
        if (driverEntity != null) {
            result = DriverEntityMapper.INSTANCE.driverEntityToDto(driverEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public List<DriverEntitySO> getAllDrivers() {
        final List<DriverEntitySO> result = new ArrayList<DriverEntitySO>();
        List<DriverEntity> driversEntity = dao.getAllDrivers();
        if (CollectionUtils.isEmpty(driversEntity)) {
            //LOG.error("NULL reference on users");
            return result;
        }
        for (DriverEntity data : driversEntity) {
            DriverEntitySO driver = DriverEntityMapper.INSTANCE.driverEntityToDto(data);
            result.add(driver);
        }
        return result;
    }
}
