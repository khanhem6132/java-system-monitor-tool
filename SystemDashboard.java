import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.io.File;
import java.util.Scanner;

public class SystemDashboard {

    public static void startDashboard() {

        try {

            OperatingSystemMXBean osBean =
                    (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

            Scanner scanner = new Scanner(System.in);

            System.out.println("\nPress ENTER to return to menu\n");

            while (true) {

                clearScreen();

                double cpu = osBean.getCpuLoad() * 100;

                if(cpu < 0) cpu = 0;

                long totalMem = osBean.getTotalMemorySize();
                long freeMem = osBean.getFreeMemorySize();
                long usedMem = totalMem - freeMem;

                double ramUsage = (usedMem * 100.0) / totalMem;

                File disk = new File("C:/");

                long totalDisk = disk.getTotalSpace();
                long freeDisk = disk.getFreeSpace();
                long usedDisk = totalDisk - freeDisk;

                double diskUsage = (usedDisk * 100.0) / totalDisk;

                System.out.println("========================================");
                System.out.println("           SYSTEM LIVE DASHBOARD");
                System.out.println("========================================\n");

                printBar("CPU ", cpu);
                printBar("RAM ", ramUsage);
                printBar("DISK", diskUsage);

                System.out.println("\nTop CPU Processes\n");

                ProcessMonitor.showTopCPUProcesses();

                System.out.println("\nUpdating every second...");
                System.out.println("Press ENTER to return to menu");

                Thread.sleep(1000);

                if(System.in.available() > 0){
                    scanner.nextLine();
                    return;
                }
            }

        } catch(Exception e){
            System.out.println("Dashboard error.");
        }
    }

    public static void printBar(String label, double percent){

        int bars = (int)(percent/5);

        if(bars > 20) bars = 20;

        System.out.print(label + " | ");

        for(int i=0;i<bars;i++)
            System.out.print("█");

        System.out.println(" " + String.format("%.0f",percent) + "%");
    }

    public static void clearScreen(){

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}