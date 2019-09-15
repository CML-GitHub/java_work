package com.aop;

public class Creatproxy implements Subject {
    private Subject subject;
    
    public Creatproxy(Subject subject){
        super();
        this.subject = subject;
    }
    
    public void shopping(){
        System.out.println("询价，还价");
        this.subject.shopping();
        System.out.println("付钱，运货");
    }
}
