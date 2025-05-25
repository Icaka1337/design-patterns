package decorator;

import models.IceCream;

public class ChocolateSprinkles extends IceCreamDecorator {
    public ChocolateSprinkles(IceCream base) {
        super(base);
    }

    @Override
    public String getDescription() {
        String desc = base.getDescription();
        if (desc.contains("с ")) {
            return desc + " и с шоколадови пръчици";
        } else {
            return desc + " с шоколадови пръчици";
        }
    }

    @Override
    public double getCost() {
        return base.getCost() + 0.80;
    }
}