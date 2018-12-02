package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.OrderexecutorEntityDao;
import net.tsystems.springframe.database.OrderexecutorEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderexecutorEntityDao")
public class OrderexecutorEntityDaoImpl extends AbstractDaoImpl<Integer, OrderexecutorEntity> implements OrderexecutorEntityDao {
    private static final Logger logger = LoggerFactory.getLogger(OrderexecutorEntityDaoImpl.class);

    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public OrderexecutorEntity getOrderExecutorById(int idOrderExecutor) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idOrderExecutor", idOrderExecutor));
        OrderexecutorEntity orderExecutor = (OrderexecutorEntity)crit.uniqueResult();

        return orderExecutor;
    }

    @Override
    public List<OrderexecutorEntity> getAllOrderExecutors() {
        Criteria criteria = getCriteria();
        List<OrderexecutorEntity> orderExecutors = (List<OrderexecutorEntity>)criteria.list();

        return orderExecutors;
    }

    @Override
    public List<OrderexecutorEntity> getAllOrderExecutorsByOrder(int idOrder) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idOrder", idOrder));
        List<OrderexecutorEntity> orderExecutors = (List<OrderexecutorEntity>)crit.list();

        return orderExecutors;
    }

    @Override
    public List<OrderexecutorEntity> getWorkingOrderExecutors() {
        Session session = getSession();
        Query query = session.createQuery("from OrderexecutorEntity where order_idOrder in (select idOrder from OrderEntity where closed=0)");
        // query.setParameter("cargo", cargo);
        logger.info(query.toString());
        logger.debug(query.toString());
        logger.error(query.toString());
        List<OrderexecutorEntity> list = (List<OrderexecutorEntity>) query.list();

        return list;
    }
}
