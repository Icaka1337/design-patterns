package decorator;

import models.IceCream;

public class ChocolateCoating extends IceCreamDecorator {
    public ChocolateCoating(IceCream base) {
        super(base);
    }

    @Override
    public String getDescription() {
        String desc = base.getDescription();
        if (desc.contains("с ")) {
            return desc + " и с шоколадова глазура";
        } else {
            return desc + " с шоколадова глазура";
        }
    }

    @Override
    public double getCost() {
        return base.getCost() + 1.50;
    }
}