package Interfaces;

/**
 * Project: homework11
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 25.01.2023 21:25 |
 * Created with IntelliJ IDEA
 */
public class Airplane implements Flyable {
    private final String model = "Воздушное судно Боинг";

    @Override
    public void fly() {
        System.out.println(model + " взлетело!");
    }

    @Override
    public void stopFlying() {
        System.out.println(model + " успешно приземлилось!");
    }

    public void park() {
        System.out.println(model + " припарковано в ангаре.");
    }

    public String getModel() {
        return model;
    }
}
