package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.impl.CityEntityDaoImpl;
import net.tsystems.springframe.database.CityEntity;
import net.tsystems.springframe.services.mappers.CityEntityMapper;
import net.tsystems.springframe.services.objects.CityEntitySO;
import net.tsystems.springframe.services.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CityServiceImpl implements CityService {

    @Autowired
    private CityEntityDaoImpl dao;

    public CityServiceImpl(){
      dao  = new CityEntityDaoImpl();
    }





    /**
     * @param city
     *            if a null object parameter is passed to method, nothing will happen
     * @return true in case of operation success
     */
    @Override
    @Transactional
    public boolean addCity(CityEntitySO city) {
        if (city == null) {
            return false;
        }
        CityEntity cityEntity = CityEntityMapper.INSTANCE.cityDtoToEntity(city);
        dao.create(cityEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateCity(CityEntitySO city) {
        if (city == null) {
            return false;
        }
        CityEntity cityEntity = CityEntityMapper.INSTANCE.cityDtoToEntity(city);
        dao.update(cityEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteCity(CityEntitySO city) {
        if (city == null) {
            return false;
        }

        CityEntity cityEntity = CityEntityMapper.INSTANCE.cityDtoToEntity(city);
        dao.delete(cityEntity);
        return true;
    }

    @Override
    @Transactional
    public CityEntitySO getCityById(int id) {
        CityEntitySO result = null;
        CityEntity cityEntity = (CityEntity) dao.getById(id);
        if (cityEntity != null) {
            result = CityEntityMapper.INSTANCE.cityEntityToDto(cityEntity);
        }
        return result;

    }

    @Override
    @Transactional
    public List<CityEntitySO> getAllCities() {
        final List<CityEntitySO> result = new ArrayList<CityEntitySO>();
        List<CityEntity> citiesEntity = dao.getAllCities();
        if (CollectionUtils.isEmpty(citiesEntity)) {
            //LOG.error("NULL reference on users");
            return result;
        }
        for (CityEntity data : citiesEntity) {
            CityEntitySO city = CityEntityMapper.INSTANCE.cityEntityToDto(data);
            result.add(city);
        }
        return result;

    }

}