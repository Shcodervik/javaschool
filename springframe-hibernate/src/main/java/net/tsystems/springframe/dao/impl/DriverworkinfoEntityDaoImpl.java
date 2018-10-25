package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.DriverworkinfoEntityDao;
import net.tsystems.springframe.database.DriverworkinfoEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("driverworkinfoEntityDao")
public class DriverworkinfoEntityDaoImpl extends AbstractDaoImpl<Integer, DriverworkinfoEntity> implements DriverworkinfoEntityDao {
    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public DriverworkinfoEntity getDriverWorkInfoById(int idDriverWorkInfo) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idDriverWorkInfo", idDriverWorkInfo));
        DriverworkinfoEntity driverWorkInfo = (DriverworkinfoEntity)crit.uniqueResult();

        return driverWorkInfo;
    }

    @Override
    public List<DriverworkinfoEntity> getAllDriverWorkInfo() {
        Criteria criteria = getCriteria();
        List<DriverworkinfoEntity> allDriverWorkInfo = (List<DriverworkinfoEntity>)criteria.list();

        return allDriverWorkInfo;
    }

    @Override
    public List<DriverworkinfoEntity> getAllDriverWorkInfoByIdDriver(int idDriver) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("Driver", idDriver));
        List<DriverworkinfoEntity> allWorkInfoByIdDriver = (List<DriverworkinfoEntity>)criteria.list();
        return allWorkInfoByIdDriver;
    }
}
