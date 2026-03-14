import java.net.InetAddress;

public class NetworkInfo {

    public static void showNetworkInfo() {

        try {

            InetAddress ip = InetAddress.getLocalHost();

            System.out.println("\n----- NETWORK INFO -----");
            System.out.println("Host Name: " + ip.getHostName());
            System.out.println("IP Address: " + ip.getHostAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}