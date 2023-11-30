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
        String folderPath = "assets/log"; //Sostituisce con il percorso della cartella desiderata

        //Crea il percorso completo per il file di log nella cartella "assets/log"
        String filePath = folderPath + File.separator + fileName;

        //Crea il file se non esiste
        File logFile = new File(filePath);
        if (!logFile.exists()) {
            logFile.createNewFile();
        }

        //Inizializza il gestore del file di log
        fh = new FileHandler(filePath, true);
        logger = Logger.getLogger("test");
        logger.addHandler(fh);

        //Configura il formatter
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }
}
