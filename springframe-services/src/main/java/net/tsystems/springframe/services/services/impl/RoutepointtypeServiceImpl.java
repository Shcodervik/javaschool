/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.RoutepointtypeEntityDao;
import net.tsystems.springframe.dao.impl.AbstractDaoImpl;
import net.tsystems.springframe.database.RoutepointtypeEntity;
import net.tsystems.springframe.services.mappers.RoutepointtypeEntityMapper;
import net.tsystems.springframe.services.objects.RoutepointtypeEntitySO;
import net.tsystems.springframe.services.services.RoutepointtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component("routepointtypeService")
public class RoutepointtypeServiceImpl implements RoutepointtypeService {
    private RoutepointtypeEntityDao dao;

    @Autowired
    public void setDao(RoutepointtypeEntityDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public boolean addRoutePointType(RoutepointtypeEntitySO routePointType) {
        if (routePointType == null) {
            return false;
        }
        RoutepointtypeEntity routepointtypeEntity = RoutepointtypeEntityMapper.INSTANCE.routepointtypeDtoToEntity(routePointType);
        ((AbstractDaoImpl)dao).create(routepointtypeEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean updateRoutePointType(RoutepointtypeEntitySO routePointType) {
        if (routePointType == null) {
            return false;
        }
        RoutepointtypeEntity routepointtypeEntity = RoutepointtypeEntityMapper.INSTANCE.routepointtypeDtoToEntity(routePointType);
        ((AbstractDaoImpl)dao).update(routepointtypeEntity);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteRoutePointType(RoutepointtypeEntitySO routePointType) {
        if (routePointType == null) {
            return false;
        }

        RoutepointtypeEntity routepointtypeEntity = RoutepointtypeEntityMapper.INSTANCE.routepointtypeDtoToEntity(routePointType);
        ((AbstractDaoImpl)dao).delete(routepointtypeEntity);
        return true;
    }

    @Override
    @Transactional
    public RoutepointtypeEntitySO getRoutePointTypeById(int id) {
        RoutepointtypeEntitySO result = null;
        RoutepointtypeEntity routepointtypeEntity = (RoutepointtypeEntity) ((AbstractDaoImpl)dao).getById(id);
        if (routepointtypeEntity != null) {
            result = RoutepointtypeEntityMapper.INSTANCE.routepointtypeEntityToDto(routepointtypeEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public RoutepointtypeEntitySO getRoutePointTypeByType(String type) {
        RoutepointtypeEntitySO result = null;
        RoutepointtypeEntity routepointtypeEntity = (RoutepointtypeEntity) dao.getRoutePointTypeByType(type);
        if (routepointtypeEntity != null) {
            result = RoutepointtypeEntityMapper.INSTANCE.routepointtypeEntityToDto(routepointtypeEntity);
        }
        return result;
    }

    @Override
    @Transactional
    public List<RoutepointtypeEntitySO> getAllRoutePointTypes() {
        final List<RoutepointtypeEntitySO> result = new ArrayList<RoutepointtypeEntitySO>();
        List<RoutepointtypeEntity> routepointtypesEntity = dao.getAllRoutePointTypes();
        if (CollectionUtils.isEmpty(routepointtypesEntity)) {
            //LOG.error("NULL reference on users");
            return result;
        }
        for (RoutepointtypeEntity data : routepointtypesEntity) {
            RoutepointtypeEntitySO routepointtype = RoutepointtypeEntityMapper.INSTANCE.routepointtypeEntityToDto(data);
            result.add(routepointtype);
        }
        return result;
    }
}
