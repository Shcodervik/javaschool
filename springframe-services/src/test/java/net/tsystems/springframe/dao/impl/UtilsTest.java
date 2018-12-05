/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package net.tsystems.springframe.dao.impl;

import junit.framework.Assert;
import junit.framework.TestCase;
import net.tsystems.springframe.services.Utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilsTest extends TestCase {
    public void testStringToDate() {
        String testString = "15-05-1991 06.04.47";
        //Date expected = new Date(1991-1900, 4, 15,6,4,47);
        Date expected = new GregorianCalendar(1991, Calendar.MAY, 15,6,4,47).getTime();
        try {
            Date testResult = Utils.stringToDate(testString);
            Assert.assertEquals(expected, testResult);
        } catch (ParseException e) {
            //Assert.assertNotNull(e.getMessage(), e);
            Assert.fail();
        }


    }
    public void testStringToDateIncorrect() {
        String testIncorrectString = "incorrect";
        try {
            Utils.stringToDate(testIncorrectString);
            Assert.assertTrue(false);
        }
        catch(ParseException e) {

        }
        catch (Exception ex)
        {
            Assert.assertNotNull(ex);
        }
    }

    public void testRoundResult(){
        double testDouble = 3.98763467;
        double expected = 3.988;
        Assert.assertEquals(expected, Utils.roundResult(testDouble,3));
    }
    public void testRoundResult2(){
        double testDouble = 3.333333;
        double expected = 3.33;
        Assert.assertEquals(expected, Utils.roundResult(testDouble,2));
    }
    public void testRoundResult3(){
        double testDouble = 99;
        double expected = 99.0;
        Assert.assertEquals(expected, Utils.roundResult(testDouble,2));
    }

    public void testDatetimeToDate() {
        Timestamp ts = new Timestamp(91,4,15,12,12,12,0);
        Date expected = new GregorianCalendar(1991, Calendar.MAY, 15,12,12,12).getTime();
        Date dt = Utils.datetimeToDate(ts);
        Assert.assertEquals(expected,dt);
    }
    public void testDatetimeToDateIncorrect() {
        Timestamp ts = null;
        Date expected = new GregorianCalendar(1991, Calendar.MAY, 15,12,12,12).getTime();
        Date dt = Utils.datetimeToDate(ts);
        Assert.assertNotSame(expected,dt);
    }

    public void testDateToDatetime() {
        Date dt = new GregorianCalendar(1991, Calendar.MAY, 15,12,12,12).getTime();
        Timestamp expected = new Timestamp(91,4,15,12,12,12,0);
        Timestamp ts = Utils.dateToDatetime(dt);
        Assert.assertEquals(expected,ts);
    }
    public void testDateToDatetimeIncorrect() {
        Date dt = null;
        Timestamp expected = new Timestamp(91,4,15,12,12,12,0);
        Timestamp ts = Utils.dateToDatetime(dt);
        Assert.assertNotSame(expected,ts);
    }
}
