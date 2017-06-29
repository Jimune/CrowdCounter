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

    public static String getRandomMac() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            char a = Constants.MAC_CHARS.charAt(Constants.RANDOM.nextInt(Constants.MAC_CHARS.length()));
            char b = Constants.MAC_CHARS.charAt(Constants.RANDOM.nextInt(Constants.MAC_CHARS.length()));

            sb.append(":").append(a).append(b);
        }

        return sb.toString().replaceFirst(":", "");
    }
}
