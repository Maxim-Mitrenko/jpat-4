import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Seller seller = null;
        Shop shop = new Shop(System.out::println);
        try (Scanner scanner = new Scanner(System.in)){
            while (true) {
                System.out.println("1. Товары \n" +
                        "2. Оплатить\n" +
                        "3. Продать товар\n" +
                        "4. Выход");
                int input = input(scanner);
                if (input == 4) break;
                switch (input) {
                    case 1 -> {
                        List<Item> itemList = shop.getItems();
                        for (int i = 0; i < itemList.size(); i++) {
                            System.out.println((i + 1) + ". " + itemList.get(i));
                        }
                        System.out.println("Введите номер товара");
                        int number = input(scanner);
                        System.out.println("Введите количество товара");
                        int count = input(scanner);
                        shop.add(itemList.get(number - 1), count);
                        System.out.println("Товар добавлен в корзину!");
                    }
                    case 2 -> {
                        if (!shop.isEmpty()) shop.buy();
                    }
                    case 3 -> {
                        if (seller == null) {
                            System.out.println("Как называется ваша организация");
                            seller = new Seller(scanner.nextLine());
                        }
                        System.out.println("Что вы хотите продавать?");
                        String item = scanner.nextLine();
                        System.out.println("Сколько будет стоить ваш товар?");
                        int price = input(scanner);
                        shop.addItem(new Item(item, price, seller));
                        System.out.println("Товар выставлен на продажу!");
                    }
                }
            }
        }
    }

    public static int input(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Введено не число. Введите повторно");
            return input(scanner);
        }
    }
}
