package com.company;

import java.lang.InterruptedException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    static int THREADS_NUMBERS = 10;
    static int LENGTH = 12000;                      //  矩阵维数
    public static int[][] Construct_Matrix(int a[][]) {           //构造矩阵
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < LENGTH; j++) {
                double d = Math.random();
                int b = (int) (d * 100);
                a[i][j] = b;
            }
        }
        return a;
    }
    
    public static void Output_Matrix(int a[][]){            //输出矩阵
        for(int i = 0;i < LENGTH;i ++){
            for(int j = 0;j < LENGTH;j ++){
                System.out.print(a[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws InterruptedException{
        // write your code here
       /* int A[][] = new int[LENGTH][LENGTH];
        int B[][] = new int[LENGTH][LENGTH];*/
        int A[][] = Construct_Matrix(new int[LENGTH][LENGTH]);
        int B[][] = Construct_Matrix(new int[LENGTH][LENGTH]);
        
        System.out.println("-----------矩阵A-----------");
        Output_Matrix(A);
        System.out.println("-----------矩阵B-----------");
        Output_Matrix(B);
        System.out.println("--------------------------");
    
        long StartTime = System.currentTimeMillis();          //开始时间
       /* //单线程
        Multithreading serial = new Multithreading(A,B,0);
        serial.Multiply();
        */
        
        //多线程  两个线程
        Thread[] threads = new Thread[THREADS_NUMBERS];
        for(int i = 0;i<THREADS_NUMBERS;i++){
            threads[i] = new Thread(new Multithreading(A,B,i));
        }
        for(int i=  0;i<THREADS_NUMBERS;i++){
            threads[i].start();
        }
        for(int i = 0;i<THREADS_NUMBERS;i++){
            try{
                threads[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        
        
        /*//线程池
        Thread[] poolworkers = new Thread[THREADS_NUMBERS];
        for(int i= 0;i<THREADS_NUMBERS;i++)
            poolworkers[i] = new Thread(new Multithreading(A,B,i));
        //建立线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        for(int i = 0;i<THREADS_NUMBERS;i++)
            pool.execute(poolworkers[i]);           //将线程放入线程池中执行
        pool.shutdown();*/
        
        
        long EndTime = System.currentTimeMillis();                  //结束时间
        System.out.println("运行时间为:" + (EndTime - StartTime));
        
    
    }
}
