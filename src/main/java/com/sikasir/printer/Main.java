package com.sikasir.printer;

import com.sikasir.printer.config.PrinterConfig;
import com.sikasir.printer.logging.LogWorker;
import com.sikasir.printer.printing.PrintServer;

/**
 * Created by purwaren on 1/6/15.
 */
public class Main {
    public static void main(String[] args) {

        PrinterConfig config = new PrinterConfig("config.properties");
        LogWorker logger = new LogWorker("logs/");

        logger.writeLog("Bringing up application");
        PrintServer printServer = new PrintServer(config, logger);
        printServer.start();

    }
}
