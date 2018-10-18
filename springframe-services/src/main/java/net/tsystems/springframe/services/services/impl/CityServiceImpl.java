package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.CityEntityDao;
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
    private CityEntityDaoImpl dao = new CityEntityDaoImpl();



    /**
     * @param city
     *            if a null object parameter is passed to method, nothing will happen
     * @return true in case of operation success
     */
    @Override
    @Transactional
    public boolean addCity(CityEntitySO city) {
        if (city == null)
        {
            return false;
        }

        try
        {

           // ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);
           // user.setPassword(encoder.encodePassword(user.getPassword(), null));
            CityEntity cityEntity = CityEntityMapper.INSTANCE.cityDtoToEntity(city);
            dao.create(cityEntity);
            return true;
        }
        catch (Exception e)
        {
           // LOG.error("Failed to add user");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    @Transactional
    public boolean updateCity(CityEntitySO city) {
        return false;
    }

    @Override
    @Transactional
    public boolean deleteCity(CityEntitySO city) {
        return false;
    }

    @Override
    @Transactional
    public CityEntitySO getCityById(int id) {
        return null;
    }

    @Override
    @Transactional
    public List<CityEntitySO> getAllCities() {
        //
        final List<CityEntitySO> result = new ArrayList<CityEntitySO>();

        List<CityEntity> citiesEntity = dao.getAllCities();

        if (CollectionUtils.isEmpty(citiesEntity))
        {
            //LOG.error("NULL reference on users");
            return result;
        }

        for (CityEntity data : citiesEntity)
        {
            CityEntitySO city = CityEntityMapper.INSTANCE.cityEntityToDto(data);
            result.add(city);
        }
        return result;

    }

}
