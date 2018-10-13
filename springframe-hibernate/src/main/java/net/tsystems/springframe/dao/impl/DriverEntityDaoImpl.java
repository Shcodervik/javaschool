package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.DriverEntityDao;
import net.tsystems.springframe.database.DriverEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("driverEntityDao")
public class DriverEntityDaoImpl extends AbstractDaoImpl<Integer, DriverEntity> implements DriverEntityDao {
    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public DriverEntity getDriverById(int idDriver) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idDriver", idDriver));
        DriverEntity driver = (DriverEntity)crit.uniqueResult();

        return driver;
    }

    @Override
    public List<DriverEntity> getDriversByName(String name) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("Name", name));
        List<DriverEntity> drivers = (List<DriverEntity>)criteria.list();
        return drivers;
    }

    @Override
    public List<DriverEntity> getDriversBySurname(String surname) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("Surname", surname));
        List<DriverEntity> drivers = (List<DriverEntity>)criteria.list();
        return drivers;
    }

    @Override
    public List<DriverEntity> getAllDrivers() {
        Criteria criteria = getCriteria();
        List<DriverEntity> drivers = (List<DriverEntity>)criteria.list();
        return drivers;
    }

    /*
    * TODO: realisation
    * */

    @Override
    public List<DriverEntity> getAllDriversByState(int driverState) {
        return null;
    }


}
