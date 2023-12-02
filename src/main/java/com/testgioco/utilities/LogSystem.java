package com.testgioco.utilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogSystem {
    public Logger logger;
    FileHandler fh;

    public LogSystem(String fileName) throws SecurityException, IOException {
        String folderPath = "assets/log"; //Replace with the desired folder path

        //Create the complete path for the log file in the 'assets/log' folder
        String filePath = folderPath + File.separator + fileName;

        //Create the file if it doesn't exist
        File logFile = new File(filePath);
        if (!logFile.exists()) {
            logFile.createNewFile();
        }

        //Initialize the log file handler.
        fh = new FileHandler(filePath, true);
        logger = Logger.getLogger("test");
        logger.addHandler(fh);

        //Configure the formatter
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }
}
