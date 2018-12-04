package net.tsystems.springframe.services;

import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Class for some functions like type conversion
 * */

public class Utils {

    /**
     * It's for converting byte to another meaning of boolean (UI needs it)
     * **/
    public static boolean byteToBool (byte i){
        if(i==1) {
            return false; //actually true
        }
        else{
            return true;  //actually false
        }
    }


    /**
     * It's for converting boolean to another meaning of byte (UI needs it)
     * **/
    public static byte boolToByte (boolean i){
        if(i){
            return 0; //actually 1
        }
        return 1;  //actually 0
    }

    /**
     * Encoding pass to SHA-1
     * */
    public static String toSHA(String pass){

        return DigestUtils.sha1Hex(pass);
    }

    public static Date datetimeToDate(Timestamp ts) {
        if(ts==null){
            return null;
        }else {
            long millis2 = ts.getTime();
            java.util.Date date = new java.util.Date(millis2);
            // Date dt = new Date(ts.getTime());
            return date;
        }
    }
    public static Timestamp dateToDatetime(Date dt) {
        if(dt==null){
            return null;
        }else {
            long millis1 = dt.getTime();
            java.sql.Timestamp ts = new java.sql.Timestamp(millis1);
            // Timestamp ts = new Timestamp(dt.getTime());
            return ts;
        }
    }

    public static Date stringToDate(String str) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss", Locale.ENGLISH);
        Date date = formatter.parse(str);
        return date;
    }
    public static String dateToString(Date dt) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss", Locale.ENGLISH);

        return formatter.format(dt);
    }

    public static double roundResult (double d, int precise) {

        precise = 10^precise;
        d = d*precise;
        int i = (int) Math.round(d);
        return (double) i/precise;

    }
}
