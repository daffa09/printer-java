package com.sikasir.printer.logging;

/**
 * Created by purwaren on 1/6/15.
 */
public class LogWorker {
    ConsoleLog console;

    public LogWorker(String logPath) {
        console = new ConsoleLog();
    }

    public void writeLog(String msg) {
        console.logDebug(msg);
    }
}
