import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class SystemMonitor {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            showMenu();

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    SystemInfo.showSystemInfo();
                    LoggerUtil.log("System information checked");
                    pause();
                    break;

                case 2:
                    printHeader("CURRENT USER");
                    System.out.println(System.getProperty("user.name"));
                    LoggerUtil.log("User checked");
                    pause();
                    break;

                case 3:
                    printHeader("JAVA VERSION");
                    System.out.println(System.getProperty("java.version"));
                    LoggerUtil.log("Java version checked");
                    pause();
                    break;

                case 4:
                    showMemory();
                    LoggerUtil.log("Memory usage checked");
                    pause();
                    break;

                case 5:
                    printHeader("CURRENT TIME");
                    System.out.println(LocalDateTime.now());
                    LoggerUtil.log("Time checked");
                    pause();
                    break;

                case 6:
                    DiskInfo.showDiskSpace();
                    LoggerUtil.log("Disk space checked");
                    pause();
                    break;

                case 7:
                    NetworkInfo.showNetworkInfo();
                    LoggerUtil.log("Network info checked");
                    pause();
                    break;

                case 8:
                    runFullSystemCheck();
                    LoggerUtil.log("Full system check executed");
                    pause();
                    break;

                case 9:
                    saveSystemInfoToFile();
                    LoggerUtil.log("System info saved");
                    pause();
                    break;

                case 10:
                    generateDiagnosticReport();
                    LoggerUtil.log("Diagnostic report generated");
                    pause();
                    break;

                case 11:
                    LoggerUtil.log("Real-time monitor started");
                    RealTimeMonitor.startMonitoring();
                    break;

                case 12:
                    SystemInfo.showUsageChart();
                    LoggerUtil.log("CPU/RAM chart viewed");
                    pause();
                    break;

                case 13:
                    SystemInfo.systemHealthAnalysis();
                    LoggerUtil.log("System health analysis executed");
                    pause();
                    break;

                case 14:
                    ProcessMonitor.showTopCPUProcesses();
                    LoggerUtil.log("Top CPU processes checked");
                    pause();
                    break;

                case 15:
                    LoggerUtil.log("Live system dashboard started");
                    SystemDashboard.startDashboard();
                    break;

                case 16:
                    NetworkSpeedMonitor.checkSpeed();
                    LoggerUtil.log("Network speed test executed");
                    pause();
                    break;

                case 17:
                    System.out.println("\nExiting program...");
                    LoggerUtil.log("Program exited");
                    return;

                default:
                    System.out.println("Invalid option");
                    pause();
            }
        }
    }

    /* ================= MENU ================= */

    public static void showMenu() {

        System.out.println("""
======================================
       IT SUPPORT DIAGNOSTIC TOOL
======================================
1  | System Information
2  | Current User
3  | Java Version
4  | Memory Usage
5  | Current Time
6  | Disk Space
7  | Network Information
8  | Full System Health Check
9  | Save System Info to File
10 | Generate Diagnostic Report
11 | Real-Time System Monitor
12 | CPU & RAM Usage Chart
13 | System Health AI Analysis
14 | Top CPU Processes
15 | Live System Dashboard
16 | Network Speed Test
17 | Exit
======================================
Enter option ➜
""");
    }

    /* ================= HEADER ================= */

    public static void printHeader(String title) {

        System.out.println("\n======================================");
        System.out.println(" " + title);
        System.out.println("======================================");
    }

    /* ================= MEMORY ================= */

    public static void showMemory() {

        printHeader("MEMORY USAGE");

        Runtime runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory() / (1024 * 1024);
        long freeMemory = runtime.freeMemory() / (1024 * 1024);

        System.out.printf("%-20s : %d MB\n", "Total Memory", totalMemory);
        System.out.printf("%-20s : %d MB\n", "Free Memory", freeMemory);
    }

    /* ================= SYSTEM CHECK ================= */

    public static void runFullSystemCheck() {

        printHeader("FULL SYSTEM HEALTH CHECK");

        SystemInfo.showSystemInfo();
        showMemory();
        DiskInfo.showDiskSpace();
        NetworkInfo.showNetworkInfo();
    }

    /* ================= SAVE INFO ================= */

    public static void saveSystemInfoToFile() {

        try {

            FileWriter writer = new FileWriter("system_info.txt");

            writer.write("===== SYSTEM INFORMATION =====\n");
            writer.write("User: " + System.getProperty("user.name") + "\n");
            writer.write("OS: " + System.getProperty("os.name") + "\n");
            writer.write("Java Version: " + System.getProperty("java.version") + "\n");
            writer.write("Time: " + LocalDateTime.now() + "\n");

            writer.close();

            System.out.println("\nSystem information saved to system_info.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ================= REPORT ================= */

    public static void generateDiagnosticReport() {

        try {

            FileWriter writer = new FileWriter("diagnostic_report.txt");

            Runtime runtime = Runtime.getRuntime();

            writer.write("===== IT SUPPORT DIAGNOSTIC REPORT =====\n");
            writer.write("User: " + System.getProperty("user.name") + "\n");
            writer.write("OS: " + System.getProperty("os.name") + "\n");
            writer.write("Java Version: " + System.getProperty("java.version") + "\n");
            writer.write("Total Memory: " + runtime.totalMemory() / (1024 * 1024) + " MB\n");
            writer.write("Free Memory: " + runtime.freeMemory() / (1024 * 1024) + " MB\n");
            writer.write("Time: " + LocalDateTime.now() + "\n");

            writer.close();

            System.out.println("\nDiagnostic report generated: diagnostic_report.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ================= PAUSE ================= */

    public static void pause() {

        System.out.println("\nPress ENTER to continue...");
        scanner.nextLine();
        scanner.nextLine();
    }
}