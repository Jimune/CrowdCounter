package nl.yc.crowdcounter.util;

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

}
