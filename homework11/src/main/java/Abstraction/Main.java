package Abstraction;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 01:33 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.run();
        cat.jump();
        cat.feedAnimal();

        Dog dog = new Dog();
        dog.run();
        dog.jump();
        dog.feedAnimal();

        Hamster hamster = new Hamster();
        hamster.run();
        hamster.jump();
        hamster.feedAnimal();
    }
}
