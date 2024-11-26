import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static final String FILE_LOG = "log_produzione.txt";

    public static synchronized void scriviLog(String messaggio) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_LOG, true))) {
            writer.write(messaggio);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
