package lyn.librpump.util;

import java.util.Date;

/**
 * Created by lyn on 16/4/14.
 */
public class CommonMethod {

    public static long getCurrentTime(){
        Date date = new Date();
        date.getTime();
        return date.getTime();
    }
}
