package com.aop;

public class TestDemo {
    public static void main(String[] args){
        Person person = new Person();
        Creatproxy cp = new Creatproxy();
        Subject proxy = ((Subject) cp.create(person));
        proxy.shopping();
    }
}
