import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerFile implements Logger {
    private static final String LOG_FILE = "ArquivoCriadoPeloLog.txt";
    private PrintWriter fileWriter;

    public void LoggerFile(String message) {
        try {
            fileWriter = new PrintWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String message, LevelDebug level) {
        String formattedMessage = getFormattedMessage(message, level);
        LoggerFile(formattedMessage);
    }

    private void logToFile(String message) {
        fileWriter.println(message);
        fileWriter.flush();
    }

    private String getFormattedMessage(String message, LevelDebug level) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());

        return String.format("[%s] %s: %s", currentTime, level.name(), message);
    }
}