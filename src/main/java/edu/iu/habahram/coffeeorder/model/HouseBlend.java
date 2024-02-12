package edu.iu.habahram.coffeeorder.model;

public class HouseBlend extends Beverage{
    @Override
    public String getDescription() {
        return "HouseBlend";
    }
    @Override
    public float cost() {
        return 1.99F;
    }
}
