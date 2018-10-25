package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.DriverstateEntityDao;
import net.tsystems.springframe.database.DriverstateEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("driverstateEntityDao")
public class DriverstateEntityDaoImpl extends AbstractDaoImpl<Integer, DriverstateEntity> implements DriverstateEntityDao {
    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public DriverstateEntity getDriverStateById(int idDriverState) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idDriverState", idDriverState));
        DriverstateEntity driverState = (DriverstateEntity)crit.uniqueResult();

        return driverState;
    }

    @Override
    public List<DriverstateEntity> getAllDriverStates() {
        Criteria criteria = getCriteria();
        List<DriverstateEntity> driverStates = (List<DriverstateEntity>)criteria.list();

        return driverStates;
    }
}
