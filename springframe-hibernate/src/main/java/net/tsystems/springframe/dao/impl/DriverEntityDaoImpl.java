package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.DriverEntityDao;
import net.tsystems.springframe.database.DriverEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("driverEntityDao")
public class DriverEntityDaoImpl extends AbstractDaoImpl<Integer, DriverEntity> implements DriverEntityDao {
    final Logger logger = LoggerFactory.getLogger(DriverEntityDaoImpl.class);

    private Session currentSession;
    private Transaction currentTransaction;

    public DriverEntityDaoImpl() {
    }

    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    @Transactional
    public DriverEntity getDriverById(int idDriver) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idDriver", idDriver));
        DriverEntity driver = (DriverEntity)crit.uniqueResult();

        return driver;
    }

    @Override
    @Transactional
    public DriverEntity getDriverByUIN(String UIN) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("UIN", UIN));
        DriverEntity driver = (DriverEntity)crit.uniqueResult();

        return driver;
    }

    @Override
    @Transactional
    public List<DriverEntity> getDriversByName(String name) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("Name", name));
        List<DriverEntity> drivers = (List<DriverEntity>)criteria.list();
        return drivers;
    }

    @Override
    @Transactional
    public List<DriverEntity> getDriversBySurname(String surname) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("Surname", surname));
        List<DriverEntity> drivers = (List<DriverEntity>)criteria.list();
        return drivers;
    }

    @Override
    @Transactional
    public List<DriverEntity> getAllDrivers() {
        Criteria criteria = getCriteria();
        List<DriverEntity> drivers = (List<DriverEntity>)criteria.list();
        return drivers;
    }



    @Override
    @Transactional
    public List<DriverEntity> getAllDriversByState(int driverState) {
        return null;
    }

    @Override
    public List<DriverEntity> getDriversForOrder() {
        Session session = getSession();
        Query query = session.createQuery("from DriverEntity d where d.idDriver not in (select driverIdDriver from OrderexecutorEntity where orderIdOrder in (select idOrder from OrderEntity where closed = 0))");
        logger.error(query.toString());
        List list = query.list();
        return list;
    }


}
