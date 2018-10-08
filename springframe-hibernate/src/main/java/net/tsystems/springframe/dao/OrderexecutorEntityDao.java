package net.tsystems.springframe.dao;

import net.tsystems.springframe.database.OrderexecutorEntity;

import java.util.List;

public interface OrderexecutorEntityDao {
    OrderexecutorEntity getOrderExecutorById(int idOrderExecutor);
    List<OrderexecutorEntity> getAllOrderExecutors();
    List<OrderexecutorEntity> getAllOrderExecutorsByOrder(int idOrder);
}
