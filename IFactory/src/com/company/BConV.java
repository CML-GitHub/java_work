package com.company;

public class BConV implements BFruitAndVegetables {
    @Override
    public Vegetables CreateV() {
        return new tomato();
    }
    
    @Override
    public Fruit CreateF() {
        return null;
    }
    
}
