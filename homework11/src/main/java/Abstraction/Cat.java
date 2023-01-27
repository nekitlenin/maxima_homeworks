package Abstraction;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 16:09 |
 * Created with IntelliJ IDEA
 */
public class Cat extends Animal {
    private final String name = "Кошка";

    @Override
    public void run() {
        System.out.println(name + " бежит!");
    }

    @Override
    public void jump() {
        System.out.println(name + " прыгает!");
    }
}
