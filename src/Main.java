import models.IceCream;
import singleton.IceCreamShop;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        IceCreamShop shop = IceCreamShop.getInstance();
        Scanner scanner = new Scanner(System.in);
        int availableIceCreams = 100;

        System.out.println("Добре дошли в магазина за сладолед!");
        System.out.println("Колко сладоледа искате да поръчате?");

        int quantity = readInt(scanner, 1, availableIceCreams);

        String[] flavors = {"ванилов", "шоколадов", "ягодов"};
        Map<Integer, String> toppingsMap = Map.of(
                1, "глазура",
                2, "пръчици"
        );

        List<IceCream> orders = new ArrayList<>();

        for (int i = 1; i <= quantity; i++) {
            // Динамично заглавие
            String flavorPrompt = quantity == 1
                    ? "Изберете вкус:"
                    : String.format("Изберете вкус на сладолед #%d:", i);
            System.out.printf("%n%s%n", flavorPrompt);

            for (int j = 0; j < flavors.length; j++) {
                System.out.printf("%d. %s%n", j + 1, capitalize(flavors[j]));
            }

            int flavorChoice = readInt(scanner, 1, flavors.length);
            String selectedFlavor = flavors[flavorChoice - 1];

            // Избор на добавки
            String toppingsPrompt = quantity == 1
                    ? "Изберете добавки (Използвайте , за да изберете повече от една / напр. 1,2):"
                    : String.format("Изберете добавки за сладолед #%d (Използвайте , за да изберете повече от една / напр. 1,2):", i);
            System.out.printf("%s%n", toppingsPrompt);

            System.out.println("1. Шоколадова глазура (+1.50 лв.)");
            System.out.println("2. Шоколадови пръчици (+0.80 лв.)");
            System.out.println("0. Без добавки");

            String toppingsInput = scanner.nextLine().trim();
            Set<String> selectedToppings = new HashSet<>();
            if (!toppingsInput.equals("0")) {
                String[] parts = toppingsInput.split(",");
                for (String part : parts) {
                    try {
                        int toppingIndex = Integer.parseInt(part.trim());
                        String topping = toppingsMap.get(toppingIndex);
                        if (topping != null) {
                            selectedToppings.add(topping);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Невалиден избор: " + part);
                    }
                }
            }

            IceCream order = shop.orderIceCream(selectedFlavor, selectedToppings.toArray(new String[0]));
            orders.add(order);
        }

        // Касова бележка
        System.out.println("\n=== КАСОВА БЕЛЕЖКА ===");
        double total = 0.0;

        int counter = 1;
        for (IceCream order : orders) {
            System.out.printf("Сладолед #%d: %s - %.2f лв.%n",
                    counter++, order.getDescription(), order.getCost());
            total += order.getCost();
        }

        System.out.printf("------------------------%nОбща сума: %.2f лв.%n", total);
    }

    private static int readInt(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Моля, въведете число между %d и %d:%n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Невалидно число. Опитайте отново:");
            }
        }
    }

    private static String capitalize(String word) {
        if (word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}