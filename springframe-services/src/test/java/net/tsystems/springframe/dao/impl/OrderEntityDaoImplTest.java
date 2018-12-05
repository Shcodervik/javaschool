/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.dao.impl;

import junit.framework.TestCase;
import net.tsystems.springframe.dao.AbstractDao;
import net.tsystems.springframe.dao.OrderEntityDao;
import net.tsystems.springframe.database.OrderEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class OrderEntityDaoImplTest extends TestCase {

    OrderEntityDao dao = new OrderEntityDaoImpl();

    public void testCreateInvalidOrder() {
        OrderEntity o = new OrderEntity();
        o.setIdOrder(0);
        o.setClosed((byte) 2);
        Timestamp date = new Timestamp(System.currentTimeMillis());
        o.setCreateDT(date);
        boolean thrown = false;
        try {
            ((AbstractDao) dao).create(o);
            thrown = true;
        } catch (Exception e) {
            thrown = false;
        }

        assertFalse(thrown);
    }
}