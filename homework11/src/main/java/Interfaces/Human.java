package Interfaces;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 21:25 |
 * Created with IntelliJ IDEA
 */
public class Human implements Walkable {
    private final String name = "Ярослав";

    @Override
    public void walk() {
        System.out.println(name + " вышел на прогулку!");
    }

    @Override
    public void stopWalking() {
        System.out.println(name + " погулял, вернулся домой, сел на диван!");
    }

    public void watchTv() {
        System.out.println(name + " начал смотреть любимый канал...");
    }

    public String getName() {
        return name;
    }
}
