/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.services.services;

import net.tsystems.springframe.services.objects.CargoEntitySO;
import net.tsystems.springframe.services.objects.OrderEntitySO;
import net.tsystems.springframe.services.objects.RoutepointEntitySO;

import java.util.Collection;
import java.util.List;

public interface RoutepointService {
    boolean addRoutePoint(RoutepointEntitySO routePointType);

    boolean updateRoutePoint(RoutepointEntitySO routePointType);

    boolean deleteRoutePoint(RoutepointEntitySO routePointType);

    boolean deleteRoutePoints(List<RoutepointEntitySO> points);

    boolean updateRoutePoints(List<RoutepointEntitySO> points);

    RoutepointEntitySO getRoutePointById(int id);
    RoutepointEntitySO getRoutePointByType(String type);
    List<RoutepointEntitySO> getRoutePointsByCargo(CargoEntitySO cargo);
    List<RoutepointEntitySO> getRoutePointsByOrder(OrderEntitySO order);

    Collection<? extends RoutepointEntitySO> getRoutePointsWithoutOrder();

    List<RoutepointEntitySO> getAllRoutePoints();
}
