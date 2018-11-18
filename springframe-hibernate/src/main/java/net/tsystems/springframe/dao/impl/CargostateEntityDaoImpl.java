package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.CargostateEntityDao;
import net.tsystems.springframe.database.CargostateEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cargoStateEntityDao")
public class CargostateEntityDaoImpl extends AbstractDaoImpl<Integer, CargostateEntity> implements CargostateEntityDao {
    @Override
    public CargostateEntity getCargoStateById(int idCargoState) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idCargoState", idCargoState));
        CargostateEntity cargoState = (CargostateEntity)crit.uniqueResult();

        return cargoState;
    }

    @Override
    public CargostateEntity getCargoStateByState(String state) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("cargoState", state));
        CargostateEntity cargoState = (CargostateEntity)crit.uniqueResult();

        return cargoState;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CargostateEntity> getAllCargoStates() {
        Session session = getSession();
        Query query = session.createQuery("from CargostateEntity");
        List list = query.list();
        return list;
    }

    @Override
    public Session getEntityManager() {
        return null;
    }
}
