package Abstraction;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 17:42 |
 * Created with IntelliJ IDEA
 */
public class Hamster extends Animal {
    private final String name = "Хомяк";

    @Override
    public void run() {
        System.out.println(name + " бежит!");
    }

    @Override
    public void jump() {
        System.out.println(name + " прыгает!");
    }
}
