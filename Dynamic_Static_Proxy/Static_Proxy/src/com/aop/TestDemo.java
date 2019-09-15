package com.aop;

public class TestDemo {
    public static void main(String[] args){
        Subject people = new Person();
        Creatproxy proxy = new Creatproxy(people);
        
        proxy.shopping();
    }
}
