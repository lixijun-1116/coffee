package com.example.coffee.utils;

import com.spire.pdf.PdfDocument;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: PrintUtils
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2021/10/29 16:15
 */
public class PrintUtils {

    /**
     * 静默打印
     * @param filePath 文件路经
     * @param copies 打印份数
     */
    public static void silentPrint(String filePath,int copies){
        System.out.println("加载文档");
        if(copies <= 0){
            copies = 1;
        }
        //加载文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(filePath);
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat  = loPrinterJob.defaultPage();
        Paper loPaper = loPageFormat.getPaper();

        //删除默认页边距
        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());

        //设置打印份数
        loPrinterJob.setCopies(copies);
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(pdf,loPageFormat);
        try {
            System.out.println("正在打印......");
            loPrinterJob.print();
            System.out.println("打印结束");
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示对话框打印
     * @param filePath 文件路经
     */
    public static void dialogBoxPrint(String filePath){
        System.out.println("加载文档");
        //加载文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(filePath);

        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat  = loPrinterJob.defaultPage();
        Paper loPaper = loPageFormat.getPaper();

        //删除默认页边距
        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());

        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(pdf,loPageFormat);

        //显示打印对话框
        if (loPrinterJob.printDialog()) {
            try {
                System.out.println("正在打印......");
                loPrinterJob.print();
                System.out.println("打印结束");
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 自定义纸张大小
     * @param filePath 文件路经
     * @param width 纸张宽度
     * @param height 纸张高度
     */
    public static void paperSizePrint(String filePath,int width,int height){
        System.out.println("加载文档");
        //加载文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(filePath);

        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat  = loPrinterJob.defaultPage();

        //设置打印纸张大小
        Paper loPaper = loPageFormat.getPaper();
        loPaper.setSize(width,height);
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(pdf,loPageFormat);
        try {
            System.out.println("正在打印......");
            loPrinterJob.print();
            System.out.println("打印结束");
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}
