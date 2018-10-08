package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.RoutepointtypeEntityDao;
import net.tsystems.springframe.database.RoutepointtypeEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("routepointtypeEntityDao")
public class RoutepointtypeEntityDaoImpl extends AbstractDaoImpl<Integer, RoutepointtypeEntity> implements RoutepointtypeEntityDao {
    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public RoutepointtypeEntity getRoutePointTypeById(int idRoutePointType) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idRPType", idRoutePointType));
        RoutepointtypeEntity routePointType = (RoutepointtypeEntity)crit.uniqueResult();

        return routePointType;
    }

    @Override
    public List<RoutepointtypeEntity> getAllRoutePointTypes() {
        Criteria criteria = getCriteria();
        List<RoutepointtypeEntity> routePointTypes = (List<RoutepointtypeEntity>)criteria.list();

        return routePointTypes;
    }
}
