package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.RoutepointEntityDao;
import net.tsystems.springframe.database.RoutepointEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("routepointEntityDao")
public class RoutepointEntityDaoImpl extends AbstractDaoImpl<Integer, RoutepointEntity> implements RoutepointEntityDao {
    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public RoutepointEntity getRoutePointById(int idRoutePoint) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idRoutePoint", idRoutePoint));
        RoutepointEntity routePoint = (RoutepointEntity)crit.uniqueResult();

        return routePoint;
    }

    @Override
    public List<RoutepointEntity> getAllRoutePoints() {
        Criteria criteria = getCriteria();
        List<RoutepointEntity> routePoints = (List<RoutepointEntity>)criteria.list();

        return routePoints;
    }
}
