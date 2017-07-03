package nl.yc.crowdcounter.util;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by jim on 6/27/17.
 */
public class Util {

    public static String build(Object... obj) {
        StringBuilder sb = new StringBuilder();

        for (Object o : obj) {
            sb.append(o);
        }

        return sb.toString();
    }

    public static String getRandomMac() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            char a = Constants.MAC_CHARS.charAt(Constants.RANDOM.nextInt(Constants.MAC_CHARS.length()));
            char b = Constants.MAC_CHARS.charAt(Constants.RANDOM.nextInt(Constants.MAC_CHARS.length()));

            sb.append(":").append(a).append(b);
        }

        return sb.toString().replaceFirst(":", "");
    }

    public static String getRandomLocation() {
        String location = Constants.LOCATIONS[Constants.RANDOM.nextInt(Constants.LOCATIONS.length)];
        return location;
    }

    public static String getRandomStrenght() {
        String strength = Constants.STRENGTHS[Constants.RANDOM.nextInt(Constants.STRENGTHS.length)];
        return strength;
    }

    public static Date getRandomDate() {
        Date date = new Date(System.currentTimeMillis() - ThreadLocalRandom.current().nextLong(20000000000L));
        return date;
    }

    public static Date beginDate(String date) {
        Date fDate = null;
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fDate = dFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fDate;
    }

    public static Date setNewTime(Date timeZone) {
        Date newTimeZone = null;
        long ltime = timeZone.getTime() + 1 * 1 * 60 * 60 * 1000;
        newTimeZone = new Date(ltime);
        return newTimeZone;
    }

    public static String setNewString(int ssid) {
        if (ssid == 0) {
            return "Weak Strenght";
        } else if (ssid == 1) {
            return "Medium Strength";
        } else return "High Strength";
    }

    public static void setRightName(HttpServletRequest request, ArrayList<Integer> hourmap, int number) {
        if (number == 0) {
            request.getSession().setAttribute("weakhourmap", hourmap);
        } else if (number == 1) {
            request.getSession().setAttribute("mediumhourmap", hourmap);
        } else {
            request.getSession().setAttribute("highhourmap", hourmap);
        }

    }


}
