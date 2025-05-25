package models;

public class VanillaIceCream implements IceCream {
    @Override
    public String getDescription() {
        return "Ванилов сладолед";
    }

    @Override
    public double getCost() {
        return 2.00;
    }
}