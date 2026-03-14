import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.net.InetAddress;
import java.time.LocalDateTime;

public class SystemInfo {

    public static void showSystemInfo() {

        try {

            String os = System.getProperty("os.name");
            String user = System.getProperty("user.name");
            String javaVersion = System.getProperty("java.version");
            String computerName = InetAddress.getLocalHost().getHostName();

            OperatingSystemMXBean osBean =
                    (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

            int cpuCores = osBean.getAvailableProcessors();

            Thread.sleep(800);

            double cpuLoad = osBean.getCpuLoad();
            if (cpuLoad < 0) cpuLoad = 0;
            cpuLoad = cpuLoad * 100;

            long totalMemory = osBean.getTotalMemorySize();
            long freeMemory = osBean.getFreeMemorySize();

            long totalGB = totalMemory / (1024 * 1024 * 1024);
            long freeGB = freeMemory / (1024 * 1024 * 1024);

            System.out.println("\n======================================");
            System.out.println("          SYSTEM INFORMATION");
            System.out.println("======================================");

            System.out.printf("%-20s : %s\n", "Computer Name", computerName);
            System.out.printf("%-20s : %s\n", "User", user);
            System.out.printf("%-20s : %s\n", "Operating System", os);
            System.out.printf("%-20s : %s\n", "Java Version", javaVersion);
            System.out.printf("%-20s : %d\n", "CPU Cores", cpuCores);
            System.out.printf("%-20s : %.2f %%\n", "CPU Usage", cpuLoad);
            System.out.printf("%-20s : %d GB\n", "Total RAM", totalGB);
            System.out.printf("%-20s : %d GB\n", "Free RAM", freeGB);
            System.out.printf("%-20s : %s\n", "Current Time", LocalDateTime.now());

            System.out.println("======================================");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showUsageChart() {

        try {

            OperatingSystemMXBean osBean =
                    (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

            Thread.sleep(500);

            double cpu = osBean.getCpuLoad() * 100;

            long total = osBean.getTotalMemorySize();
            long free = osBean.getFreeMemorySize();
            long used = total - free;

            double ramUsage = (used * 100.0) / total;

            System.out.println("\n===== CPU & RAM USAGE CHART =====");

            printBar("CPU", cpu);
            printBar("RAM", ramUsage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void systemHealthAnalysis() {

        try {

            OperatingSystemMXBean osBean =
                    (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

            Thread.sleep(500);

            double cpu = osBean.getCpuLoad() * 100;

            long total = osBean.getTotalMemorySize();
            long free = osBean.getFreeMemorySize();
            long used = total - free;

            double ramUsage = (used * 100.0) / total;

            System.out.println("\n===== SYSTEM HEALTH AI ANALYSIS =====");

            if (cpu > 80)
                System.out.println("⚠ CPU usage very high");

            else if (cpu > 50)
                System.out.println("CPU usage moderate");

            else
                System.out.println("CPU operating normally");

            if (ramUsage > 80)
                System.out.println("⚠ Memory almost full");

            else if (ramUsage > 50)
                System.out.println("Memory usage moderate");

            else
                System.out.println("Memory status healthy");

            if (cpu < 50 && ramUsage < 50)
                System.out.println("\nSystem performance: GOOD");

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
}