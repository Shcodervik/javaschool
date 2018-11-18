/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.RoutepointEntityDao;
import net.tsystems.springframe.dao.impl.AbstractDaoImpl;
import net.tsystems.springframe.database.RoutepointEntity;
import net.tsystems.springframe.services.mappers.RoutepointEntityMapper;
import net.tsystems.springframe.services.objects.RoutepointEntitySO;
import net.tsystems.springframe.services.services.RoutepointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component("routepointService")
public class RoutepointServiceImpl implements RoutepointService {

    private RoutepointEntityDao dao;

    @Autowired
    public void setDao(RoutepointEntityDao dao) {
        this.dao = dao;
    }




    @Override
    @Transactional
    public boolean addRoutePoint(RoutepointEntitySO routePointType) {
        if (routePointType == null) {
            return false;
        }
        RoutepointEntity routepointEntity = RoutepointEntityMapper.INSTANCE.routepointDtoToEntity(routePointType);
        ((AbstractDaoImpl)dao).create(routepointEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateRoutePoint(RoutepointEntitySO routePointType) {
        if (routePointType == null) {
            return false;
        }
        RoutepointEntity routepointEntity = RoutepointEntityMapper.INSTANCE.routepointDtoToEntity(routePointType);
        ((AbstractDaoImpl)dao).update(routepointEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteRoutePoint(RoutepointEntitySO routePointType) {
        if (routePointType == null) {
            return false;
        }
        RoutepointEntity routepointEntity = RoutepointEntityMapper.INSTANCE.routepointDtoToEntity(routePointType);
        ((AbstractDaoImpl)dao).delete(routepointEntity);
        return true;
    }

    @Override
    @Transactional
    public RoutepointEntitySO getRoutePointById(int id) {
        RoutepointEntitySO result = null;
        RoutepointEntity routepointEntity = (RoutepointEntity) ((AbstractDaoImpl)dao).getById(id);
        if (routepointEntity != null) {
            result = RoutepointEntityMapper.INSTANCE.routepointEntityToDto(routepointEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public RoutepointEntitySO getRoutePointByType(String type) {
        return null;
    }

    @Override
    @Transactional
    public List<RoutepointEntitySO> getAllRoutePoints() {
        final List<RoutepointEntitySO> result = new ArrayList<RoutepointEntitySO>();
        List<RoutepointEntity> routepointsEntity = dao.getAllRoutePoints();
        if (CollectionUtils.isEmpty(routepointsEntity)) {
            //LOG.error("NULL reference on users");
            return result;
        }
        for (RoutepointEntity data : routepointsEntity) {
            RoutepointEntitySO routepoint = RoutepointEntityMapper.INSTANCE.routepointEntityToDto(data);
            result.add(routepoint);
        }
        return result;
    }
}
