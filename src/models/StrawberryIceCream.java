package models;

public class StrawberryIceCream implements IceCream {
    @Override
    public String getDescription() {
        return "Ягодов сладолед";
    }

    @Override
    public double getCost() {
        return 2.20;
    }
}