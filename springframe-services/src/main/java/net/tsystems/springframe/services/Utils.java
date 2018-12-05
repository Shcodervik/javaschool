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
    private static double EPSILON = 0.0001;
    /**
     * It's for converting byte to another meaning of boolean (UI needs it)
     * Mappers use this method
     *
     * @param i Byte value for converting
     * @return Another meaning of boolean value
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
     * Mappers use this method
     *
     * @param i Boolean value for converting
     * @return Another meaning of byte value
     *
     * **/
    public static byte boolToByte (boolean i){
        if(i){
            return 0; //actually 1
        }
        return 1;  //actually 0
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

    /**Rounding double value
     *
     * @param d Double value for rounding
     * @param precise Accuracy for rounding value
     *
     * @return Rounding value
     * */
    public static double roundResult (double d, int precise) {
        double c = 0.5 * EPSILON * d;
        //  double p = Math.pow(10, precision); //slow
        double p = 1; while (precise-- > 0) p *= 10;
        if (d < 0)
            p *= -1;
        return Math.round((d + c) * p) / p;

    }
}
