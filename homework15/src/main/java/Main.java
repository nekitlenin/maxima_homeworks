import java.util.*;

/**
 * Project: homework15
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 09.02.2023 15:18 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        sortRandomNumbers();
        setOfWords();
        mapOfChars();
    }

    private static void sortRandomNumbers() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++)
            list.add(random.nextInt(100));
        System.out.println("Before " + list);
        Collections.sort(list);
        System.out.println("After  " + list);
    }

    private static void setOfWords() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press string: ");
        Set<String> set = new HashSet<>(Arrays.asList
                (scanner.nextLine()
                        .toLowerCase()
                        .split(" ")));
        System.out.println("Set of words: " + set);
    }

    private static void mapOfChars() {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        System.out.print("Press string: ");
        char[] chars = scanner.nextLine()
                .toLowerCase()
                .toCharArray();

        for (char c : chars)
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        System.out.println("Chars          " + Arrays.toString(chars));
        System.out.println("Count of chars " + map);
    }
}
