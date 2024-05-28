import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerConsole implements Logger {
    @Override
    public void log(String message, LevelDebug level) {
        String formattedMessage = getFormattedMessage(message, level);
        logToConsole(formattedMessage);
    }

    private void logToConsole(String message) {
        System.out.println(message);
    }

    private String getFormattedMessage(String message, LevelDebug level) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String currentTime = formatter.format(new Date());
        String color = getColor(level);

        return String.format("%s %s %s %s", color, currentTime, level.name(), message);
    }

    private String getColor(LevelDebug level) {
        switch (level){
            case DEBUG:
                return "\u001B[32m"; // Green
            case WARNING:
                return "\u001B[33m"; // Yellow
            case ERROR:
                return "\u001B[31m"; // Red
            default:
                return "";
        }
    }
}