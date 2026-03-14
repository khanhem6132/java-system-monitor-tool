import java.io.FileWriter;
import java.time.LocalDateTime;

public class LoggerUtil {

    public static void log(String message) {

        try {

            FileWriter writer = new FileWriter("system_log.txt", true);

            writer.write("[" + LocalDateTime.now() + "] " + message + "\n");

            writer.close();

        }

        catch(Exception e){
            System.out.println("Unable to write log.");
        }
    }
}