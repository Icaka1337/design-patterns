package singleton;

import decorator.ChocolateCoating;
import decorator.ChocolateSprinkles;
import factory.IceCreamFactory;
import models.IceCream;

public class IceCreamShop {
    private static IceCreamShop instance;

    private IceCreamShop() {}

    public static synchronized IceCreamShop getInstance() {
        if (instance == null) {
            instance = new IceCreamShop();
        }
        return instance;
    }

    public IceCream orderIceCream(String flavor, String... toppings) {
        IceCream iceCream = IceCreamFactory.createIceCream(flavor);
        for (String topping : toppings) {
            iceCream = switch (topping.toLowerCase()) {
                case "глазура" -> new ChocolateCoating(iceCream);
                case "пръчици" -> new ChocolateSprinkles(iceCream);
                default -> iceCream;
            };
        }
        return iceCream;
    }
}
