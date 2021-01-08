<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>


</head>
<body>
<button onclick="WeiXin()">点击</button>
<!-- 存放二维码的容器 -->
<img  id="qrcode" style="padding-left: 20px">
</body>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
    function WeiXin() {
        //清空二维码文本框
        $("#qrcode").html("");
        var url4 = "https://mail.qq.com/cgi-bin/frame_html?sid=zPEPAVod2JCmE18A&r=bdc08ea982bcb4d1c53982d15be81887";
        $("#qrcode").attr("src", "/qrcode?content=" + url4);
    }
</script>
</html>