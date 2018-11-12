/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.services.services;

import net.tsystems.springframe.services.objects.OrderexecutorEntitySO;

import java.util.List;

public interface OrderexecutorService {

    boolean addOrderexecutor(OrderexecutorEntitySO orderExecutor);

    boolean updateOrderexecutor(OrderexecutorEntitySO orderExecutor);

    boolean deleteOrderexecutor(OrderexecutorEntitySO orderExecutor);

    OrderexecutorEntitySO getOrderexecutorById(int id);

    List<OrderexecutorEntitySO> getAllOrderexecutors();




}
