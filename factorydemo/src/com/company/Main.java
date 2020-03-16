package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        UMLutil umLutil = new UMLutil();
        factory ft = (factory) umLutil.getBean();
        role rl = ft.createrole();
        rl.init();
    }
}
