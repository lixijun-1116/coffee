package com.example.coffee.utils.exceptions;

public class DaoBiException extends AdminException{


    public DaoBiException() {
        super("人数太少，要倒闭了");
    }
}
