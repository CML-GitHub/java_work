package com;

public class TestIntegerMatrix {
    public static void main(String[] args){
        
        Integer[][] m1 = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
        Integer[][] m2 = new Integer[][]{{1,1,1},{2,2,2},{3,3,3}};
        
        IntegerMatrix integerMatrix = new IntegerMatrix();
        
        System.out.println("m1 + m2 is");
        GenericMatrix.printResult(m1,m2,integerMatrix.addMatrix(m1,m2),'+');
        
        System.out.println("\nm1 * m2 is");
        GenericMatrix.printResult(m1,m2,integerMatrix.multiplyMatrix(m1,m2),'*');
    }
}
