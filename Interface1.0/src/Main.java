public class Main {
    public static void main(String[] args) {
        // Console logger
        Logger consolelogger = new LoggerConsole();

        consolelogger.log("", LevelDebug.DEBUG);
        consolelogger.log("", LevelDebug.WARNING);
        consolelogger.log("", LevelDebug.ERROR);

        // File logger
        Logger filelogger = new LoggerFile();

        filelogger.log("", LevelDebug.DEBUG);
        filelogger.log("", LevelDebug.WARNING);
        filelogger.log("", LevelDebug.ERROR);
    }
}