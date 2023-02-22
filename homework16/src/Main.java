import pojo.Item;
import pojo.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Project: homework16
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 21.02.2023 01:39 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите набор фамилий:");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

        getStringByFirstChar(scanner, list);
        sortArray(list);

        LocalDateTime afterDate = LocalDateTime.of(1999, 2, 2, 2, 2);
        LocalDateTime beforeDate = LocalDateTime.of(2023, 2, 2, 2, 2);
        String substringItem = "ip";

        System.out.println(getOrdersByDate(afterDate, beforeDate));
        System.out.println(getOrdersByDateAndByNameItem(afterDate, beforeDate, substringItem));
    }

    /**
     * 1. На входе получаем список Фамилий сотрудников.
     * Необходимо вывести всех сотрудников, которые начинаются на определённый символ.
     * (Например, вывести всех сотрудников с фамилий начинающихся на "Е")
     */
    private static void getStringByFirstChar(Scanner scanner, ArrayList<String> list) {
        System.out.println("По какой букве искать?");
        char c = scanner.next().toLowerCase().charAt(0);

        System.out.println("Строки, начинающиеся с символа " + c + ":");
        list.stream()
                .filter(w -> w.charAt(0) == c || w.charAt(0) == c - 32)
                .forEach(System.out::println);
    }

    /**
     * 2. В консоль вводится список слов через пробел.
     * Во время сортировки нужно вывести сначала изначальный порядок слов.
     * Это значит надо вывести элементы посредством StreamAPI. А после выполнения работы сортировки конечный.
     * При этом задача должна быть выполнена за 1 Stream. То есть может быть только 1 терминальная операция
     *
     * @param list слова в виде списка, который отсортирован лексикографическом порядке.
     */
    private static void sortArray(ArrayList<String> list) {
        list.stream()
                .peek(s -> System.out.println("До сортировки - " + s))
                .sorted()
                .forEach(s -> System.out.println("После сортировки - " + s));
    }

    /**
     * 3. На входе подаётся LIst<Order>
     * Вернуть все заказы, которые были совершены в определённом промежутке времени (от и до).
     *
     * @param afterDate  дата от которой искать
     * @param beforeDate дата до которой искать
     */
    private static List<Order> getOrdersByDate(LocalDateTime afterDate, LocalDateTime beforeDate) {
        System.out.println("Товары в данный промежуток времени:");
        return (Order.makeOrderList().stream()
                .filter(order -> order.getCreateDate().isAfter(afterDate)
                        && order.getCreateDate().isBefore(beforeDate))
                .collect(Collectors.toList()));
    }

    /**
     * 4. Необходимо вернуть список купленных товаров с определённым именем за определённый промежуток.
     * Это значит был List<Order>, а стал List<Item>. В нём только те товары,
     * что купили в промежуток от и до и в их имени присутствуют определённая подстрока.
     * И самое главное, это всё за 1 Stream!
     *
     * @param afterDate     дата от которой искать
     * @param beforeDate    дата до которой искать
     * @param substringItem - подстрока для поиска
     * @return лист Item у которых в имени присутствует searchItem без учёта регистра
     */
    private static List<Item> getOrdersByDateAndByNameItem(LocalDateTime afterDate, LocalDateTime beforeDate,
                                                           String substringItem) {
        System.out.println("Товары в данный промежуток времени с названием " + substringItem + ":");
        return (Order.makeOrderList().stream()
                .filter(order -> order.getCreateDate().isAfter(afterDate)
                        && order.getCreateDate().isBefore(beforeDate))
                .flatMap(order -> order.getItemList().stream()
                        .filter(item -> item.getName().toLowerCase().contains(substringItem.toLowerCase())))
                .collect(Collectors.toList()));
    }
}
