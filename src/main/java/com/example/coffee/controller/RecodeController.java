package com.example.coffee.controller;

import com.example.coffee.utils.MatrixToImageWriter;
import com.example.coffee.utils.RecodeUtil;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;

/**
 * @version v1.0
 * @ProjectName: coffee
 * @ClassName: RecodeController
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 李茜骏
 * @Date: 2020/8/14 14:17
 */
@Controller
public class RecodeController {

    @RequestMapping(value = "/")
    public String into(){
        return "test";
    }

    /**
     * 生成微信图片二维码
     *
     * @param request
     * @param response
     * @param content   为前端传过来的二维码的内容，即路径链接
     * @throws Exception
     */
    @RequestMapping(value = "/qrcode")
    public void qrcode(HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "content") String content) throws Exception {
        if (StringUtils.isBlank(content)) {
            response.sendRedirect("/404.html");
            return;
        }
        //调用工具类，生成二维码
        RecodeUtil.creatRrCode(content, 180, 180, response);   //180为图片高度和宽度
    }
}
