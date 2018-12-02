package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.OrderEntityDao;
import net.tsystems.springframe.database.OrderEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository("orderEntityDao")
public class OrderEntityDaoImpl extends AbstractDaoImpl<Integer, OrderEntity> implements OrderEntityDao {
    private static final Logger logger = LoggerFactory.getLogger(OrderEntityDaoImpl.class);

    @Override
    public Session getEntityManager() {
        return null;
    }

    @Override
    public OrderEntity getOrderById(int idOrder) {
        Criteria crit = getCriteria();
        crit.add(Restrictions.eq("idOrder", idOrder));
        OrderEntity order = (OrderEntity)crit.uniqueResult();

        return order;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OrderEntity> getAllOrders() {
        Session session = getSession();
        Query query = session.createQuery("select o from OrderEntity o");
       // query.setParameter("cargo", cargo);
        logger.info(query.toString());
        logger.debug(query.toString());
        logger.error(query.toString());
        List<OrderEntity> list = (List<OrderEntity>) query.list();

        return list;
        /*Criteria criteria = getCriteria();
        List<OrderEntity> orders = (List<OrderEntity>)criteria.list();

        return orders;*/
    }
}
