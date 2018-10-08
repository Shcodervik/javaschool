package net.tsystems.springframe.dao.impl;

import net.tsystems.springframe.dao.OrderEntityDao;
import net.tsystems.springframe.database.OrderEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("orderEntityDao")
public class OrderEntityDaoImpl extends AbstractDaoImpl<Integer, OrderEntity> implements OrderEntityDao {
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
    public List<OrderEntity> getAllOrders() {
        Criteria criteria = getCriteria();
        List<OrderEntity> orders = (List<OrderEntity>)criteria.list();

        return orders;
    }
}
