package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.TruckEntityDao;
import net.tsystems.springframe.database.TruckEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("truckEntityDao")
public class TruckEntityDaoImpl extends AbstractDaoImpl<Integer, TruckEntity> implements TruckEntityDao {
    private static final Logger logger = LoggerFactory.getLogger(TruckEntityDaoImpl.class);


    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public TruckEntity getTruckById(int idTruck) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idTruck", idTruck));
        TruckEntity truck = (TruckEntity)crit.uniqueResult();
        return truck;
    }

    @Override
    public TruckEntity getTruckBySerial(String serial) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("Serial", serial));
        TruckEntity truckBySerial = (TruckEntity)crit.uniqueResult();
        return truckBySerial;
    }

    @Override
    public List<TruckEntity> getAllTrucks() {
        Criteria criteria = getCriteria();
        List<TruckEntity> trucks = (List<TruckEntity>)criteria.list();

        return trucks;
    }

    @Override
    public List<TruckEntity> getTrucksByCapacity(float capacity) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("Capacity", capacity));
        List<TruckEntity> trucksByCapacity = (List<TruckEntity>)criteria.list();
        return trucksByCapacity;
    }

    @Override
    public List<TruckEntity> getTrucksByState(int idTruckState) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("TruckState", idTruckState));
        List<TruckEntity> trucksByState = (List<TruckEntity>)criteria.list();
        return trucksByState;
    }

    @Override
    public List<TruckEntity> getTrucksByDriversNumber(int driversNumber) {
        Criteria criteria = getCriteria();
        criteria.add(Restrictions.eq("DriversNumber", driversNumber));
        List<TruckEntity> trucksByDriversNumber = (List<TruckEntity>)criteria.list();
        return trucksByDriversNumber;
    }

    @Override
    public List<TruckEntity> getTrucksForOrder(Double capacity) {
        Session session = getSession();
        Query query = session.createQuery("from TruckEntity t where t.truckStateIdTruckState=1 and capacity >= :cap order by capacity");
        query.setParameter("cap", capacity);
        logger.error(query.toString());
        List list = query.list();
        return list;
    }
}
