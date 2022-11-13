package com.sikasir.printer.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PrinterConfig
{
    private int paperType;
    private double top;
    private double left;
    private double right;
    private double bottom;
    private String font;
    private int fontSize;
    private int port;
    private int type;
    private int orientation;

    public PrinterConfig(String fileConfig)
    {
        Properties props = new Properties();
        try
        {
            FileInputStream in = new FileInputStream(fileConfig);
            props.load(in);
            in.close();

            this.type = Integer.parseInt(props.getProperty("type"));
            this.port = Integer.parseInt(props.getProperty("port"));
            this.paperType = Integer.parseInt(props.getProperty("paperType"));
            this.top = Double.parseDouble(props.getProperty("top"));
            this.left = Double.parseDouble(props.getProperty("left"));
            this.right = Double.parseDouble(props.getProperty("right"));
            this.bottom = Double.parseDouble(props.getProperty("bottom"));
            this.font = props.getProperty("font");
            this.fontSize = Integer.parseInt(props.getProperty("fontSize"));
            this.orientation = Integer.parseInt(props.getProperty("orientation"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getPaperType() {
        return paperType;
    }

    public void setPaperType(int paperType) {
        this.paperType = paperType;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double top) {
        this.top = top;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getRight() {
        return right;
    }

    public void setRight(double right) {
        this.right = right;
    }

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }
}