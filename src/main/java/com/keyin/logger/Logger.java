package com.keyin.logger;

import javax.naming.spi.DirectoryManager;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    private static final String LOG_FILE = "application.log";
    public static void log(String message, String level) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            LocalDateTime now = LocalDateTime.now();
            StringBuilder sb = new StringBuilder();
            sb.append(now);
            sb.append(" ");
            sb.append(level);
            sb.append(" ");
            sb.append(message);
//            message =  level + " " + now + " " + message;
            writer.write(sb + "\n");
        } catch (IOException e) {
            Logger.errorLog("Error writing to log file");
            e.printStackTrace();
        }
    }

    public static void errorLog(Exception e) {
        log(e.getMessage() , "ERROR");
    }
    public static void errorLog(String message) {
        log(message , "ERROR");
    }
    public static void infoLog(String message) {
        log(message, "INFO");
    }
    public static void debugLog(String message) {
        log(message , "DEBUG");
    }
    public static void warnLog(String message) {
        log(message , "WARN");
    }
    public static void traceLog(String message) {
        log(message , "TRACE");
    }


}
