package com.company;

import static com.company.Main.LENGTH;
import static com.company.Main.THREADS_NUMBERS;

public class Multithreading extends Thread {
    private int A[][] = new int[LENGTH][LENGTH];
    private int B[][] = new int[LENGTH][LENGTH];
    private int C[][] = new int[LENGTH][LENGTH];
    private int start;
    
    public Multithreading(int a[][],int b[][],int s ){
        this.A = a;
        this.B = b;
        this.start = s;
    }
    public void run(){
        for(int i = 0;i< LENGTH;i++)
            for(int j =0;j<LENGTH;j++)
                C[i][j] = 0;                //每次计算前先将和数组的值归零
        
        for(int i = start; i< LENGTH; i += THREADS_NUMBERS) {       //矩阵并行乘法
            for(int j=0;j < LENGTH; j ++) {
                C [i][j] = 0;
                for(int k=0; k< LENGTH; k ++) {
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
    }
    public void Multiply() {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < LENGTH; k++) {
                    C[i][k] += A[i][k] * B[j][k];
                }
            }
        }
        
    }
}
