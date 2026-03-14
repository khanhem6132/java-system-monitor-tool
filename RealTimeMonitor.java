import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.io.File;

public class RealTimeMonitor {

    public static void startMonitoring() {

        try {

            OperatingSystemMXBean osBean =
                    (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

            System.out.println("\nStarting Live Dashboard...");
            System.out.println("Press ENTER to return to menu.");

            while (true) {

                Thread.sleep(1000);

                double cpu = osBean.getCpuLoad() * 100;

                long totalMem = osBean.getTotalMemorySize();
                long freeMem = osBean.getFreeMemorySize();
                long usedMem = totalMem - freeMem;

                double ramUsage = (usedMem * 100.0) / totalMem;

                File disk = new File("C:/");

                long totalDisk = disk.getTotalSpace();
                long freeDisk = disk.getFreeSpace();
                long usedDisk = totalDisk - freeDisk;

                double diskUsage = (usedDisk * 100.0) / totalDisk;

                clearScreen();

                System.out.println("=====================================");
                System.out.println("        SYSTEM LIVE DASHBOARD");
                System.out.println("=====================================");

                printBar("CPU ", cpu);
                printBar("RAM ", ramUsage);
                printBar("DISK", diskUsage);

                System.out.println("\nUpdating every second...");
                System.out.println("Press ENTER to return to menu.");

                // check nếu user nhấn ENTER
                if (System.in.available() > 0) {
                    System.in.read();
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printBar(String label, double percent) {

        int bars = (int) (percent / 5);

        System.out.print(label + " | ");

        for (int i = 0; i < bars; i++)
            System.out.print("█");

        System.out.println(" " + String.format("%.0f", percent) + "%");
    }

    private static void clearScreen() {

        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception ignored) {}
    }
}