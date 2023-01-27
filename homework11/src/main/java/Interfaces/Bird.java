package Interfaces;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 21:27 |
 * Created with IntelliJ IDEA
 */
public class Bird implements Walkable, Flyable {
    private final String name = "Голубь Арсений";

    @Override
    public void fly() {
        System.out.println(name + " взмахнул крыльями и полетел!");
    }

    @Override
    public void stopFlying() {
        System.out.println(name + " приземлился подкрепиться!");
    }

    @Override
    public void walk() {
        System.out.println(name + " идёт в сторону семечек!");
    }

    @Override
    public void stopWalking() {
        System.out.println(name + " остановился подумать о смысле бытия...");
    }

    public void eat() {
        System.out.println(name + " жадно кушает семечки!");
    }

    public String getName() {
        return name;
    }
}
