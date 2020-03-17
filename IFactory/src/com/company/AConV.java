package com.company;

public class AConV implements AFruitAndVegetables{
    @Override
    public Vegetables CreateV() {
        return new cabbage();
    }
    
    @Override
    public Fruit CreateF() {
        return null;
    }
}
