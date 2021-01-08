package com.example.coffee.utils.redis;

import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;

import java.io.IOException;

public class UserAgent {

    public static UASparser uaSparser=null;

    static {
        try {
            uaSparser=new UASparser(OnlineUpdater.getVendoredInputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
