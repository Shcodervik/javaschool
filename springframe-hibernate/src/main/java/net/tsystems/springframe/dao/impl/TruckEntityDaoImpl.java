package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.TruckEntityDao;
import net.tsystems.springframe.database.TruckEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("truckEntityDao")
public class TruckEntityDaoImpl extends AbstractDaoImpl<Integer, TruckEntity> implements TruckEntityDao {
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
}
