package com.testgioco.utilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogSystem {
    private final Logger logger;
    FileHandler fileHandler;


    public LogSystem(String loggerName, Level loggerLevel, String fileName) throws SecurityException, IOException {
        logger = Logger.getLogger(loggerName);
        logger.setLevel(loggerLevel);
        String folderPath = "assets/log"; //Replace with the desired folder path

        //Create the complete path for the log file in the 'assets/log' folder
        String filePath = folderPath + File.separator + fileName;

        //Create the file if it doesn't exist
        File logFile = new File(filePath);
        if (!logFile.exists()) {
            logFile.createNewFile();
        }

        //Initialize the log file handler.
        fileHandler = new FileHandler(filePath, true);
        logger.addHandler(fileHandler);

        //Configure the formatter
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
    }
    public void logInfo(String message){
        logger.info(message);
    }
    public void logWarning(String message){
        logger.warning(message);
    }

    public void logSevere(String message){
        logger.severe(message);
    }
}
