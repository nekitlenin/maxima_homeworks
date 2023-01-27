package Interfaces;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 21:22 |
 * Created with IntelliJ IDEA
 */
public interface Walkable {
    default void canWalk() {
        System.out.println("Умеет ходить!");
    }

    void walk();

    void stopWalking();
}
