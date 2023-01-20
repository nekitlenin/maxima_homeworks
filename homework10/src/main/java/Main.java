import cars.Bmw;
import cars.Lada;
import cars.Tesla;

/**
 * Project: homework10
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.01.2023 14:13 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Bmw bmw = new Bmw("m3", 2000000, "black",
                200, 100, 7, 2000);
        bmw.setMaxSpeed(240);
        bmw.ride();
        bmw.brake();
        bmw.takeFuel();
        bmw.makeChipTuning();

        Lada lada = new Lada("kalina", 700000, "red",
                199, 130, 5, 1500);
        lada.setEquipment("Max equipment");
        lada.ride();
        lada.brake();
        lada.takeFuel();
        lada.brokeEngine();
        lada.fixEngine();
        lada.makeBlackWindows();

        Tesla tesla = new Tesla("model X", 6000000, "white",
                249, 95, 6, 3000);
        tesla.setMileAge(500);
        tesla.ride();
        tesla.brake();
        tesla.takeFuel();
        tesla.takeEnergy();
        tesla.onAutoPilot();
        tesla.offAutoPilot();
    }
}
