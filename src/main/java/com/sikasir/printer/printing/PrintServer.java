package com.sikasir.printer.printing;

import com.sikasir.printer.config.PrinterConfig;
import com.sikasir.printer.logging.LogWorker;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.awt.print.PrinterException;
import java.net.InetSocketAddress;

/**
 * Created by purwaren on 1/6/15.
 */
public class PrintServer extends WebSocketServer {
    private LogWorker logger;
    private PrinterConfig config;


    public PrintServer(PrinterConfig conf, LogWorker log) {

        super(new InetSocketAddress(conf.getPort()));
        this.config = conf;
        this.logger = log;
        logger.writeLog("Listening on port "+conf.getPort());

    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        logger.writeLog("Connection open");
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        logger.writeLog("Connection closed");
    }

    @Override
    public void onMessage(WebSocket webSocket, String message) {
        logger.writeLog("Receiving message : "+message);
        if (config.getType() == 1) {
            try {
                new PrintFixPaper(message, config);
            } catch (PrinterException e) {
                logger.writeLog("ERROR: "+e.getMessage());
            }
        }
        else if (config.getType() == 0) {
            try {
                new PrintReceiptPaper(message, config);
            } catch (PrinterException e) {
                logger.writeLog("ERROR: "+e.getMessage());
            }
        }
        webSocket.close();
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        logger.writeLog("Connection error : "+e.getMessage());
    }
}

