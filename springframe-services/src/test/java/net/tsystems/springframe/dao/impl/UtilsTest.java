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

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilsTest extends TestCase {
    public void testStringToDate() {
        //dd-MM-yyyy HH.mm.ss
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
    public void testIncorrectStringToDate() {
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
}
