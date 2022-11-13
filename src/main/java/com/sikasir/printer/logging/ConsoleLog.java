package com.sikasir.printer.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by purwaren on 1/6/15.
 */
public class ConsoleLog {
    private DateFormat df;

    public ConsoleLog() {
        df = new SimpleDateFormat("dd/mm/yyyy Hh:mm:ss.SSS");
    }

    public void logDebug(String msg) {
        Date now = new Date();
        System.out.println(df.format(now)+": "+msg);
    }
}
