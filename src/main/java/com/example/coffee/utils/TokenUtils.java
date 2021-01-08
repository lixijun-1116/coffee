package com.example.coffee.utils;





import com.example.coffee.model.entity.AdAdmin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TokenUtils {

    public static String createToken(AdAdmin admin, String type){
        StringBuilder builder=new StringBuilder();
        builder.append("token-");
        builder.append(admin.getAdminType()+"-");
        builder.append(type+"-");
        String info=MD5.getMD5(admin.getAid().toString());
        builder.append(info+"-");
        builder.append(new SimpleDateFormat(
                "yyyyMMddHHmmss").format(new Date()));
        builder.append(UUID.randomUUID().
                toString().substring(0,6));
        return builder.toString();
    }


}
