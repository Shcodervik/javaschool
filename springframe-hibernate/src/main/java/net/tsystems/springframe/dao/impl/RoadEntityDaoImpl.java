package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.RoadEntityDao;
import net.tsystems.springframe.database.RoadEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roadEntityDao")
public class RoadEntityDaoImpl extends AbstractDaoImpl<Integer, RoadEntity> implements RoadEntityDao {
    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public RoadEntity getRoadById(int idRoad) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idRoad", idRoad));
        RoadEntity road = (RoadEntity)crit.uniqueResult();

        return road;
    }

    @Override
    public List<RoadEntity> getAllRoads() {
        Criteria criteria = getCriteria();
        List<RoadEntity> roads = (List<RoadEntity>)criteria.list();

        return roads;
    }

  /*  @Override
    public List<RoadEntity> getAllRoadsByOriginCity(String originCity) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("OriginCity", originCity));
        List<RoadEntity> roadsByOriginCity = (List<RoadEntity>)crit.list();

        return roadsByOriginCity;
    }

    @Override
    public List<RoadEntity> getAllRoadsByDestinationCity(String destinationCity) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("DestinationCity", destinationCity));
        List<RoadEntity> roadsByDestinationCity = (List<RoadEntity>)crit.list();

        return roadsByDestinationCity;
    }*/
}
