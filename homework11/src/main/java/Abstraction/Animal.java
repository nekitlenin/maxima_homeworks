package Abstraction;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 16:07 |
 * Created with IntelliJ IDEA
 */
public abstract class Animal {
    abstract void run();

    abstract void jump();

    public void feedAnimal() {
        System.out.println("Вы накормили животное!");
    }
}
