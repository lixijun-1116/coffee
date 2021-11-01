package com.example.coffee.utils;


import com.spire.pdf.*;
import java.awt.print.*;
/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: SilentPrint
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2021/10/29 15:40
 */

public class SilentPrint {
    public static void main(String[] args) {
        //加载文档
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile("E:/1000道Java 程序员必备面试题-V1版.pdf");
        PrinterJob loPrinterJob = PrinterJob.getPrinterJob();
        PageFormat loPageFormat  = loPrinterJob.defaultPage();
        Paper loPaper = loPageFormat.getPaper();

        //删除默认页边距
        loPaper.setImageableArea(0,0,loPageFormat.getWidth(),loPageFormat.getHeight());

        //设置打印份数
        loPrinterJob.setCopies(1);
        loPageFormat.setPaper(loPaper);
        loPrinterJob.setPrintable(pdf,loPageFormat);
        try {
            loPrinterJob.print();
            System.out.println("结束");
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}