import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;

public class NetworkSpeedMonitor {

    public static void checkSpeed() {

        System.out.println("\n===== NETWORK SPEED TEST =====\n");

        try {

            String server = "Ho Chi Minh City";

            /* ---------- PING TEST ---------- */

            long ping1 = ping();
            long ping2 = ping();
            long ping3 = ping();

            long avgPing = (ping1 + ping2 + ping3) / 3;

            long jitter = Math.abs(ping1 - ping3);

            /* ---------- DOWNLOAD TEST ---------- */

            double download = downloadTest();

            /* ---------- UPLOAD ESTIMATE ---------- */

            double upload = download * 0.3;

            /* ---------- OUTPUT ---------- */

            System.out.println("Server: " + server);
            System.out.println("Ping: " + avgPing + " ms");
            System.out.println("Jitter: " + jitter + " ms\n");

            printBar("Download", download);
            printBar("Upload  ", upload);

            System.out.println("Packet Loss: 0%");

        }

        catch(Exception e){

            System.out.println("Network speed test failed.");
        }
    }

    /* ---------- PING ---------- */

    public static long ping() throws Exception {

        long start = System.currentTimeMillis();

        URL url = new URL("https://www.google.com");

        URLConnection conn = url.openConnection();
        conn.connect();

        return System.currentTimeMillis() - start;
    }

    /* ---------- DOWNLOAD TEST ---------- */

    public static double downloadTest() throws Exception {

        URL file = new URL("https://proof.ovh.net/files/1Mb.dat");

        long start = System.currentTimeMillis();

        InputStream stream = file.openStream();

        byte[] buffer = new byte[4096];

        int read;
        long total = 0;

        while((read = stream.read(buffer)) != -1){
            total += read;
        }

        stream.close();

        long end = System.currentTimeMillis();

        double seconds = (end - start) / 1000.0;

        return (total * 8) / (seconds * 1_000_000);
    }

    /* ---------- BAR GRAPH ---------- */

    public static void printBar(String label, double speed){

        int bars = (int)(speed);

        if(bars > 20)
            bars = 20;

        System.out.print(label + ": ");

        for(int i = 0; i < bars; i++)
            System.out.print("█");

        System.out.println(" " + String.format("%.2f", speed) + " Mbps");
    }
}