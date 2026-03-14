import java.io.File;

public class DiskInfo {

    public static void showDiskSpace() {

        File[] drives = File.listRoots();

        System.out.println("\n----- DISK SPACE -----");

        for (File drive : drives) {

            long total = drive.getTotalSpace() / (1024 * 1024 * 1024);
            long free = drive.getFreeSpace() / (1024 * 1024 * 1024);

            System.out.println("Drive: " + drive);
            System.out.println("Total Space: " + total + " GB");
            System.out.println("Free Space: " + free + " GB");
        }
    }
}