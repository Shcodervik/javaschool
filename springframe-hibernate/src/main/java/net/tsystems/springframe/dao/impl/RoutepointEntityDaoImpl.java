package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.RoutepointEntityDao;
import net.tsystems.springframe.database.CargoEntity;
import net.tsystems.springframe.database.OrderEntity;
import net.tsystems.springframe.database.RoutepointEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
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
    public List<RoutepointEntity> getRoutePointsByType(int idRPType) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idRPType", idRPType));
        List<RoutepointEntity> routePoints = (List<RoutepointEntity>)crit.list();
        return routePoints;
    }

    @Override
    public List<RoutepointEntity> getRoutePointsByCargo(CargoEntity cargo) {
        Session session = getSession();
        Query query = session.createQuery("from RoutepointEntity r where r.cargoIdCargo= :cargo");
        query.setParameter("cargo", cargo);
        List list = query.list();
        return list;
        //return routePoints;
    }

    @Override
    public List<RoutepointEntity> getAllRoutePoints() {
        Criteria criteria = getCriteria();
        List<RoutepointEntity> routePoints = (List<RoutepointEntity>)criteria.list();

        return routePoints;
    }

    @Override
    public List<RoutepointEntity> getRoutePointsByOrder(OrderEntity order) {
        Session session = getSession();
        Query query = session.createQuery("from RoutepointEntity r where r.orderIdOrder= :orderId order by cargoIdCargo");
        query.setParameter("orderId", order);
        List list = query.list();
        return list;
    }
}
