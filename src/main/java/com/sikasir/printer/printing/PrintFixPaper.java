package com.sikasir.printer.printing;

import com.sikasir.printer.config.PrinterConfig;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PrintFixPaper
{
    public static final int POINT_PER_INCH = 72;
    public static final double INCH_TO_MM = 25.399999999999999D;

    public PrintFixPaper(String document, PrinterConfig conf) throws PrinterException {
        PrinterJob printJob = PrinterJob.getPrinterJob();

        Book book = new Book();

        PageFormat documentPageFormat = new PageFormat();

        documentPageFormat.setOrientation(conf.getOrientation());
        documentPageFormat.setPaper(createPaper(conf.getPaperType(), conf.getTop(), conf.getLeft(), conf.getRight(), conf.getBottom()));

        book.append(new Document(document, conf), documentPageFormat);

        printJob.setPageable(book);
        if(printJob.printDialog())
            printJob.print();

    }

    public Paper createPaper(int option, double top, double left, double right, double bottom)
    {
        Paper paper = new Paper();
        double width = 0.0D;
        double height = 0.0D;
        left = left / 25.399999999999999D * 72.0D;
        right = right / 25.399999999999999D * 72.0D;
        top = top / 25.399999999999999D * 72.0D;
        bottom = bottom / 25.399999999999999D * 72.0D;

        if (option == 1) {
            paper.setSize(594.0D, 841.0D);
            width = 594.0D - 2.0D * left;
            height = 841.0D - 2.0D * top;
        }
        else if (option == 2) {
            paper.setSize(420.0D, 594.0D);
            width = 420.0D - 2.0D * left;
            height = 594.0D - 2.0D * top;
        }
        else if (option == 3) {
            paper.setSize(612.0D, 1008.0D);
            width = 612.0D - 2.0D * left;
            height = 1008.0D - 2.0D * top;
        }
        else if (option == 4) {
            paper.setSize(612.0D, 792.0D);
            width = 612.0D - 2.0D * left;
            height = 792.0D - 2.0D * top;
        }
        else if (option == 5) {
            paper.setSize(594.0D, 420.0D);
            width = 594.0D - 2.0D * left;
            height = 420.0D - 2.0D * top;
        }

        paper.setImageableArea(left, top, width, height);
        return paper;
    }
}