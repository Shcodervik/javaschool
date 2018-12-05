/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.AbstractDao;
import net.tsystems.springframe.dao.OrderEntityDao;
import net.tsystems.springframe.dao.impl.AbstractDaoImpl;
import net.tsystems.springframe.database.OrderEntity;
import net.tsystems.springframe.services.mappers.OrderEntityMapper;
import net.tsystems.springframe.services.objects.OrderEntitySO;
import net.tsystems.springframe.services.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component("orderService")
public class OrderServiceImpl implements OrderService {

    private OrderEntityDao dao;

    @Autowired
    public void setDao(OrderEntityDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public boolean addOrder(OrderEntitySO order) {
        if (order == null) {
            return false;
        }
        OrderEntity orderEntity = OrderEntityMapper.INSTANCE.orderDtoToEntity(order);
        ((AbstractDao)dao).create(orderEntity);
        order.setIdOrder(orderEntity.getIdOrder());
        return true;
    }

    @Override
    @Transactional
    public boolean updateOrder(OrderEntitySO order) {
        if (order == null) {
            return false;
        }
        OrderEntity orderEntity = OrderEntityMapper.INSTANCE.orderDtoToEntity(order);
        ((AbstractDao)dao).update(orderEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteOrder(OrderEntitySO order) {
        if (order == null) {
            return false;
        }

        OrderEntity orderEntity = OrderEntityMapper.INSTANCE.orderDtoToEntity(order);
        ((AbstractDao)dao).delete(orderEntity);
        return true;
    }

    @Override
    @Transactional
    public OrderEntitySO getOrderById(int id) {
        OrderEntitySO result = null;
        OrderEntity orderEntity = (OrderEntity) ((AbstractDao)dao).getById(id);
        if (orderEntity != null) {
            result = OrderEntityMapper.INSTANCE.orderEntityToDto(orderEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public List<OrderEntitySO> getAllOrders() {
        final List<OrderEntitySO> result = new ArrayList<OrderEntitySO>();
        List<OrderEntity> ordersEntity = dao.getAllOrders();
        if (CollectionUtils.isEmpty(ordersEntity)) {
            return result;
        }
        for (OrderEntity data : ordersEntity) {
            OrderEntitySO orders = OrderEntityMapper.INSTANCE.orderEntityToDto(data);
            result.add(orders);
        }
        return result;
    }
}
