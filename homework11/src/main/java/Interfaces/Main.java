package Interfaces;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 21:44 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        System.out.println(airplane.getModel());
        airplane.canFly();
        airplane.fly();
        airplane.stopFlying();
        airplane.park();

        System.out.println("--------------------------");

        Human human = new Human();
        System.out.println(human.getName());
        human.canWalk();
        human.walk();
        human.stopWalking();
        human.watchTv();

        System.out.println("--------------------------");

        Bird bird = new Bird();
        System.out.println(bird.getName());
        bird.canFly();
        bird.canWalk();
        bird.fly();
        bird.stopFlying();
        bird.walk();
        bird.stopWalking();
        bird.eat();
    }
}
