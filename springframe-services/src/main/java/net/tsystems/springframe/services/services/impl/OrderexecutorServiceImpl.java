/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.services.services.impl;


import net.tsystems.springframe.dao.OrderexecutorEntityDao;
import net.tsystems.springframe.dao.impl.AbstractDaoImpl;
import net.tsystems.springframe.database.OrderexecutorEntity;
import net.tsystems.springframe.services.mappers.OrderexecutorEntityMapper;
import net.tsystems.springframe.services.objects.OrderexecutorEntitySO;
import net.tsystems.springframe.services.services.OrderexecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component("orderExecutorService")
public class OrderexecutorServiceImpl implements OrderexecutorService {

    private OrderexecutorEntityDao dao;

    @Autowired
    public void setDao(OrderexecutorEntityDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public boolean addOrderexecutor(OrderexecutorEntitySO orderExecutor) {
        if (orderExecutor == null) {
            return false;
        }
        OrderexecutorEntity orderexecutorEntity = OrderexecutorEntityMapper.INSTANCE.orderexecutorDtoToEntity(orderExecutor);
        ((AbstractDaoImpl)dao).create(orderexecutorEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateOrderexecutor(OrderexecutorEntitySO orderExecutor) {
        if (orderExecutor == null) {
            return false;
        }
        OrderexecutorEntity orderexecutorEntity = OrderexecutorEntityMapper.INSTANCE.orderexecutorDtoToEntity(orderExecutor);
        ((AbstractDaoImpl)dao).update(orderexecutorEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteOrderexecutor(OrderexecutorEntitySO orderExecutor) {
        if (orderExecutor == null) {
            return false;
        }

        OrderexecutorEntity orderexecutorEntity = OrderexecutorEntityMapper.INSTANCE.orderexecutorDtoToEntity(orderExecutor);
        ((AbstractDaoImpl)dao).delete(orderexecutorEntity);
        return true;
    }

    @Override
    @Transactional
    public OrderexecutorEntitySO getOrderexecutorById(int id) {
        OrderexecutorEntitySO result = null;
        OrderexecutorEntity orderexecutorEntity = (OrderexecutorEntity) ((AbstractDaoImpl)dao).getById(id);
        if (orderexecutorEntity != null) {
            result = OrderexecutorEntityMapper.INSTANCE.orderexecutorEntityToDto(orderexecutorEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public List<OrderexecutorEntitySO> getAllOrderexecutors() {
        final List<OrderexecutorEntitySO> result = new ArrayList<OrderexecutorEntitySO>();
        List<OrderexecutorEntity> orderexecutorsEntity = dao.getAllOrderExecutors();
        if (CollectionUtils.isEmpty(orderexecutorsEntity)) {
            return result;
        }
        for (OrderexecutorEntity data : orderexecutorsEntity) {
            OrderexecutorEntitySO orderexecutor = OrderexecutorEntityMapper.INSTANCE.orderexecutorEntityToDto(data);
            result.add(orderexecutor);
        }
        return result;
    }
}
