package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.OrderEntity;

import java.util.List;

public interface OrderEntityDao {
    OrderEntity getOrderById(int idOrder);
    List<OrderEntity> getAllOrders();
}
