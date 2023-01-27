package Interfaces;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 21:27 |
 * Created with IntelliJ IDEA
 */
public interface Flyable {
    default void canFly() {
        System.out.println("Умеет летать!");
    }

    void fly();

    void stopFlying();
}
