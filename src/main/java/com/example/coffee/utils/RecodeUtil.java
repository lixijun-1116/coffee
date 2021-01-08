package com.example.coffee.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: RecodeUtil
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/8/14 12:11
 */
public class RecodeUtil {
    public static void creatRrCode(String contents, int width, int height, HttpServletResponse response){
        Hashtable hints = new Hashtable();

        //容错级别最高
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //设置字符编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //二维码空白区域,最小为0也有白边,只是很小,最小是6像素左右
        hints.put(EncodeHintType.MARGIN, 1);
        try {
            // 1、读取文件转换为字节数组
            BitMatrix bitMatrix;
            bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
            //ByteArrayOutputStream out = new ByteArrayOutputStream();
            BufferedImage image = toBufferedImage(bitMatrix);
            //转换成png格式的IO流
            ImageIO.write(image, "png", response.getOutputStream());
            //byte[] bytes = out.toByteArray();
            // 2、将字节数组转为二进制
            //BASE64Encoder encoder = new BASE64Encoder();
            //binary = encoder.encodeBuffer(bytes).trim();
        } catch (WriterException e) { // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * image流数据处理
     *
     * @author ianly
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        return image;
    }
    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            System.out.println(11);
        }
        long l1 = System.currentTimeMillis();
        long s=l1- l;
        System.out.println("总用时间为:"+s);
    }
}
