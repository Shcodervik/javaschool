/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.services.services.impl;

import net.tsystems.springframe.dao.RoadEntityDao;
import net.tsystems.springframe.database.RoadEntity;
import net.tsystems.springframe.services.mappers.RoadEntityMapper;
import net.tsystems.springframe.services.objects.RoadEntitySO;
import net.tsystems.springframe.services.services.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component("roadService")
public class RoadServiceImpl implements RoadService {

    private RoadEntityDao dao;

    @Autowired
    public void setDao(RoadEntityDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public List<RoadEntitySO> getAllRoads() {
        final List<RoadEntitySO> result = new ArrayList<RoadEntitySO>();
        List<RoadEntity> driversEntity = dao.getAllRoads();
        if (CollectionUtils.isEmpty(driversEntity)) {
            //LOG.error("NULL reference on users");
            return result;
        }
        for (RoadEntity data : driversEntity) {
            RoadEntitySO driver = RoadEntityMapper.INSTANCE.roadEntityToDto(data);
            result.add(driver);
        }
        return result;
    }
}
