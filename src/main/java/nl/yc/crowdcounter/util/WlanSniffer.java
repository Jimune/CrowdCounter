package nl.yc.crowdcounter.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yvo.romp on 27/06/2017.
 */


public class WlanSniffer {
    private static boolean runLoop = true;

    public static Set<String> checkAllHosts() {
        Set<String> addresses = new HashSet<String>();
        String subnet = "10.2.8";
        System.out.println("run sniffer.......");
        int setTime = 150;
        int count = 0;
        for (int i = 0; i < 255; i++) {
            String hostName = subnet + "." + i;

            try {
                if (InetAddress.getByName((hostName)).isReachable(setTime)) {
                    System.out.println("" + hostName);
                    addresses.add(hostName);
                    count++;
                }
            } catch (IOException e) {
                System.out.println("there is an IOException");
            }
        }
        System.out.println("devices is proximity : " + count);
        System.out.println("\n" + "Sniffer-program terminated");
        return addresses;
    }

    public static void checkAllConnections() {
        Enumeration nis = null;
        int counter = 0;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            System.out.println("socketexception!");
        }
        while (nis.hasMoreElements()) {
            NetworkInterface ni = (NetworkInterface) nis.nextElement();
            Enumeration ias = ni.getInetAddresses();
            while (ias.hasMoreElements()) {
                InetAddress ia = (InetAddress) ias.nextElement();
                System.out.println(ia.getHostAddress());
                counter++;
            }
        }
        System.out.println("count : " + counter);
    }

    public static void postAction(String givenUrl, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(givenUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("content-type", "application/json");
            connection.setDoOutput(true); //sets url connection for output

            //send request
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(urlParameters);
            out.close();

        } catch (Exception e) {
            System.out.println("String can't be parsed to a valid URL");
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

    }


}
