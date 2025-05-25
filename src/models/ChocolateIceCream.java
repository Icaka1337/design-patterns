package models;

public class ChocolateIceCream implements IceCream {
    @Override
    public String getDescription() {
        return "Шоколадов сладолед";
    }

    @Override
    public double getCost() {
        return 2.50;
    }
}