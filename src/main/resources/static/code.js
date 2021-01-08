function WeiXin() {
    //清空二维码文本框
    $("#qrcode").html("");
    var url4 = "https://ida.webank.com/api/web/login?webankAppId=TIDAutFq&version=1.0.0&nonce=E50B4E3EB0CB48C7B00B99745195BCC3&orderNo=12354646787&h5faceId=e15500ad035702afbb979f144592a913&userId=adfsewq&sign=F4B6D100379FF6C06E02C6AA264B83FB9C5493E4&url=lll&from=browser&resultType=1";
    $("#qrcode").attr("src", "/getCode/qrcode?content=" + url4);
}