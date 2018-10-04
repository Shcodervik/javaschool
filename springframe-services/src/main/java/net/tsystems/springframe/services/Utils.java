package net.tsystems.springframe.services;

public class Utils {
    public static boolean byteToBool (byte i){
        return i == 1;
    }

    public static byte boolToByte (boolean i){
        if(i){
            return 1;
        }
        return 0;
    }
}
