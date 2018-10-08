package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.TruckstateEntityDao;
import net.tsystems.springframe.database.TruckstateEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("truckstateEntityDao")
public class TruckstateEntityDaoImpl extends AbstractDaoImpl<Integer, TruckstateEntity> implements TruckstateEntityDao {
    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public TruckstateEntity getTruckStateById(int idTruckState) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idTruckState", idTruckState));
        TruckstateEntity truckState = (TruckstateEntity)crit.uniqueResult();
        return truckState;

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TruckstateEntity> getAllTruckStates() {
        Criteria criteria = getCriteria();
        List<TruckstateEntity> truckStates = (List<TruckstateEntity>)criteria.list();

        return truckStates;
    }
}
