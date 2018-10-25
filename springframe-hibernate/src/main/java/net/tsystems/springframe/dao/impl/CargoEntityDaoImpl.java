package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.CargoEntityDao;
import net.tsystems.springframe.database.CargoEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cargoEntityDao")
public class CargoEntityDaoImpl extends AbstractDaoImpl<Integer, CargoEntity> implements CargoEntityDao {

        @SuppressWarnings("unchecked")
        public List<CargoEntity> getAllCargo()
        {
            Criteria criteria = getCriteria();
            List<CargoEntity> cargoes = (List<CargoEntity>)criteria.list();

            return cargoes;
        }

        @Override
        public CargoEntity getCargoById(int idCargo)
        {
            Criteria crit = getCriteria();
            crit.add(Restrictions.eq("idCargo", idCargo));
            CargoEntity cargo = (CargoEntity)crit.uniqueResult();

            return cargo;
        }

        @Override
        public List<CargoEntity> getAllCargoByState(String state){
            Criteria criteria = getCriteria();
            criteria.add(Restrictions.eq("CargoState", state));
            List<CargoEntity> cargoes = (List<CargoEntity>)criteria.list();
            return cargoes;
        }

    @Override
    public Session getEntityManager() {
        return null;
    }
}
