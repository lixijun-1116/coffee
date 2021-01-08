package com.example.coffee.utils.redis;

import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class BaseUUID {
    /**
     * 生成唯一标识符
     *
     * @return 唯一标识符
     */
    public static String generate() {
        return Integer.toHexString(ThreadLocalRandom.current().nextInt(11111111, 99999999)) + UUID.randomUUID().toString().replaceAll("-", "") + Integer.toHexString(ThreadLocalRandom.current().nextInt(11111111, 99999999));
    }

    public static String generateNum() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) + "" + (calendar.get(Calendar.MONTH) + 1) + calendar.get(Calendar.DATE) + ((int) (Math.random() * 999999999) + 100000000) + "";
    }

}
