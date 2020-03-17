package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        AFruitAndVegetables aFruitAndVegetables = new AConF();
        Fruit fruit = aFruitAndVegetables.CreateF();
        fruit.eat();
        aFruitAndVegetables = new AConV();
        Vegetables vegetables = aFruitAndVegetables.CreateV();
        vegetables.eat();
        
        BFruitAndVegetables bFruitAndVegetables = new BConV();
        Vegetables vegetables1 = bFruitAndVegetables.CreateV();
        vegetables1.eat();
        bFruitAndVegetables = new BConF();
        Fruit fruit1 = bFruitAndVegetables.CreateF();
        fruit1.eat();
    }
}
