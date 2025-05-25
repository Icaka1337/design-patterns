package factory;

import models.ChocolateIceCream;
import models.IceCream;
import models.StrawberryIceCream;
import models.VanillaIceCream;

public class IceCreamFactory {
    public static IceCream createIceCream(String flavor) {
        return switch (flavor.toLowerCase()) {
            case "ванилов" -> new VanillaIceCream();
            case "шоколадов" -> new ChocolateIceCream();
            case "ягодов" -> new StrawberryIceCream();
            default -> throw new IllegalArgumentException("Невалиден вкус: " + flavor);
        };
    }
}