import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> shoppingList = new ArrayList<>(); //коллекция "список покупок"
        String[] action = {"добавить в список", "показать список", "удалить из списка"};
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
            if (numOperation == 0) {
                System.out.println("что вы хотите купить?");
                String input2 = scanner.nextLine(); // берём из консоли строку
                shoppingList.add(input2); //кладём её в список покупок
            } else if (numOperation == 1) {
                System.out.println("ваш список покупок:");  //выводим список на экран
                String[] shopping = shoppingList.toArray(new String[0]); //конвертация в массив
                for (int i = 0; i < shopping.length; i++) {
                    System.out.println((i + 1) + "\t" + shopping[i]); // вывод на экран
                }
            } else {
                System.out.println("вот ваш список покупок, что вы хотите удалить?");
                String[] shopping = shoppingList.toArray(new String[0]); //конвертация в массив
                for (int i = 0; i < shopping.length; i++) {
                    System.out.println((i + 1) + "\t" + shopping[i]); // вывод на экран
                }
                System.out.println("(введите номер или название)");
                String input3 = scanner.nextLine(); // берём из консоли строку
                try {
                    numShopping = Integer.parseInt(input3) - 1;
                    System.out.println("покупка " + shoppingList.get(numShopping) + " удалена, ваш список покупок:");
                    shoppingList.remove(numShopping);
                    String[] shopping2 = shoppingList.toArray(new String[0]);
                    for (int i = 0; i < shopping2.length; i++) {
                        System.out.println((i + 1) + "\t" + shopping2[i]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("покупка " + input3 + " удалена, ваш список покупок:");
                    shoppingList.remove(input3);
                    String[] shopping2 = shoppingList.toArray(new String[0]);
                    for (int i = 0; i < shopping2.length; i++) {
                        System.out.println((i + 1) + "\t" + shopping2[i]);
                    }
                }
            }
        }
    }
}
