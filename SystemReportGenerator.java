import java.io.FileWriter;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.time.LocalDateTime;

public class SystemReportGenerator {

    public static void exportJSON(){

        try{

            OperatingSystemMXBean osBean =
                (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

            double cpu = osBean.getCpuLoad()*100;

            long totalMem = osBean.getTotalMemorySize();
            long freeMem = osBean.getFreeMemorySize();

            String json =
            "{\n" +
            "\"time\":\""+LocalDateTime.now()+"\",\n"+
            "\"cpu_usage\":\""+String.format("%.2f",cpu)+"%\",\n"+
            "\"total_ram\":\""+(totalMem/(1024*1024*1024))+" GB\",\n"+
            "\"free_ram\":\""+(freeMem/(1024*1024*1024))+" GB\"\n"+
            "}";

            FileWriter writer = new FileWriter("system_report.json");

            writer.write(json);

            writer.close();

            System.out.println("System report exported to system_report.json");

        }
        catch(Exception e){
            System.out.println("Export failed.");
        }
    }
}