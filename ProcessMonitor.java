import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessMonitor {

    public static void showTopCPUProcesses() {

        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "powershell",
                    "-Command",
                    "Get-Process | Sort-Object CPU -Descending | Select-Object -First 5 Name,CPU"
            );

            Process process = builder.start();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            System.out.println("\n=====================================");
            System.out.println("        TOP CPU PROCESSES");
            System.out.println("=====================================");

            System.out.printf("%-20s %-15s\n", "Process Name", "CPU Time (s)");
            System.out.println("-------------------------------------");

            String line;

            boolean headerPassed = false;

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty())
                    continue;

                if (line.contains("Name")) {
                    headerPassed = true;
                    continue;
                }

                if (!headerPassed)
                    continue;

                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {

                    String name = parts[0];

                    double cpu = 0;

                    try {
                        cpu = Double.parseDouble(parts[1]);
                    } catch (Exception ignored) {}

                    System.out.printf("%-20s %-15.0f\n", name, cpu);
                }
            }

        } catch (Exception e) {

            System.out.println("Unable to retrieve process information.");
        }
    }
}