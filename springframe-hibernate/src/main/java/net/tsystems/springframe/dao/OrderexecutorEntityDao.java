package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.OrderexecutorEntity;

import java.util.List;

public interface OrderexecutorEntityDao {
    OrderexecutorEntity getOrderexecutorById(int idOrderexecutor);
    List<OrderexecutorEntity> getAllOrderexecutors();
    List<OrderexecutorEntity> getAllOrderexecutorsByOrder(int idOrder);
}
