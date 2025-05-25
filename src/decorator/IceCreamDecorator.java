package decorator;

import models.IceCream;

public abstract class IceCreamDecorator implements IceCream {
    protected IceCream base;

    public IceCreamDecorator(IceCream base) {
        this.base = base;
    }

    @Override
    public String getDescription() {
        return base.getDescription();
    }

    @Override
    public double getCost() {
        return base.getCost();
    }
}