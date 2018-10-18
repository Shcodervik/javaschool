package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.CityEntityDao;
import net.tsystems.springframe.database.CityEntity;
import net.tsystems.springframe.SessionService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("cityEntityDao")
public class CityEntityDaoImpl extends AbstractDaoImpl<Integer, CityEntity> implements CityEntityDao {

    private Session currentSession;
    private Transaction currentTransaction;
    public CityEntityDaoImpl() {
    }

    @Override
    public CityEntity getCityById(int idCity) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idCity", idCity));

        CityEntity city = (CityEntity) crit.uniqueResult();
        return city;
    }

    @Override
    public List<CityEntity> getAllCities() {
        Criteria criteria = getCriteria();
        List<CityEntity> cities = (List<CityEntity>)criteria.list();

        return cities;
    }

    @Override
    public void deleteAllCities() {
        List<CityEntity> entityList = getAllCities();
        for (CityEntity entity : entityList) {
            delete(entity);
        }
    }


    @Override
    public Session getEntityManager() {
        return null;
    }



}
