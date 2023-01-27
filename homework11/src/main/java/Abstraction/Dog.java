package Abstraction;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 16:10 |
 * Created with IntelliJ IDEA
 */
public class Dog extends Animal {
    private final String name = "Собака";

    @Override
    public void run() {
        System.out.println(name + " бежит!");
    }

    @Override
    public void jump() {
        System.out.println(name + " прыгает!");
    }
}
