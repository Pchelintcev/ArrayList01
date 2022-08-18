import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shoppingList = new ArrayList<>(); //список покупок
        String[] action = {"добавить в список", "показать список", "удалить из списка", "поиск по списку", "выход из пограммы"};
        System.out.println("Вы составляете список для покупки в магазине,");
        System.out.println("перед вами список доступных операций:");
        for (int i = 0; i < action.length; i++) {
            System.out.println((i + 1) + "\t" + action[i]);
        }

        while (true) {
            System.out.println("выбери номер операции");
            String input = scanner.nextLine(); // берём из консоли строку
            int numOperation;
            int numShopping;

            //TODO проверить что введен int (не string)
            try {
                numOperation = Integer.parseInt(input) - 1; // String переводим в int - 1
            } catch (NumberFormatException e) {
                System.out.println("вводить надо номер операции, вы ввели: " + input);
                continue;
            }

            //TODO проверить номер операции
            if (numOperation < 0 || numOperation >= action.length) {
                System.out.println("такой номер не предусмотрен программой.");
                continue;
            }

            //TODO использование операций:
            if (numOperation == 0) { //TODO добавление к списку:
                System.out.println("что вы хотите купить?");
                String input2 = scanner.nextLine(); // берём из консоли строку
                shoppingList.add(input2); //кладём её в список покупок
            } else if (numOperation == 1) { //TODO демонстрация списка:
                System.out.println("ваш список покупок:");
                print(shoppingList);
            } else if (numOperation == 2) {//TODO удаление из списка:
                System.out.println("вот ваш список покупок, что вы хотите удалить?");
                print(shoppingList);
                System.out.println("(введите номер или название)");
                String input3 = scanner.nextLine(); // берём из консоли строку
                //TODO если число:
                try {
                    numShopping = Integer.parseInt(input3) - 1;
                    System.out.println("покупка " + shoppingList.get(numShopping) + " удалена, ваш список покупок:");
                    shoppingList.remove(numShopping);
                    //TODO если текст:
                } catch (NumberFormatException e) {
                    System.out.println("покупка " + input3 + " удалена, ваш список покупок:");
                    shoppingList.remove(input3);
                } finally {
                    print(shoppingList);
                }
            } else if (numOperation == 3) { //TODO поиск по списку:
                System.out.println("ведите текст для поиска:");
                String search = scanner.nextLine(); //поисковый запрос
                String searchLower = search.toLowerCase(); //поисковый запрос -> нижний регистр
                for (int i = 0; i < shoppingList.size(); i++) {
                    if (shoppingList.get(i).toLowerCase().contains(searchLower)) {
                        int index = shoppingList.indexOf(shoppingList.get(i).toLowerCase());
                        System.out.println((index + 1) + " " + shoppingList.get(i));
                    }
                }
            } else {
                System.out.println("До свидания, удачной покупки.");
                break;
            }
        }
    }
    public static void print(List<String> shoppingList) {
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println((i + 1) + " " + shoppingList.get(i));
        }
    }
}
