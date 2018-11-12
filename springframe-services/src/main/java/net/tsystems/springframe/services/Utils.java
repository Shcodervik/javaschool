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
    public static boolean byteToBool (byte i){
        if(i==1) {
            return true;
        }
        else{
            return false;
        }
    }

    public static byte boolToByte (boolean i){
        if(i){
            return 1;
        }
        return 0;
    }

    /**
     * Encoding pass to SHA-1
     * */
    public static String toSHA(String pass){

        return DigestUtils.sha1Hex(pass);
    }

    public static Date datetimeToDate(Timestamp ts) {
        Date dt = new Date(ts.getTime());
        return dt;
    }
    public static Timestamp dateToDatetime(Date dt) {
        Timestamp ts = new Timestamp(dt.getTime());
        return ts;
    }

    public static Date stringToDate(String str) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy hh.mm.ss", Locale.ENGLISH);
        Date date = formatter.parse(str);
        return null;
    }
}
