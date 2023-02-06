import models.EnumShip;
import models.Map;
import models.Player;
import models.Ship;

/**
 * Project: seaBattle
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 04.01.2023 03:51 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Player nikita = new Player("Nikita");
        Ship boat1 = new Ship(nikita, EnumShip.BOAT);
        Ship destroyer1 = new Ship(nikita, EnumShip.DESTROYER);
        Ship cruiser1 = new Ship(nikita, EnumShip.CRUISER);
        Ship battleship1 = new Ship(nikita, EnumShip.BATTLESHIP);
        Map map1 = new Map(nikita);
        nikita.setMap(map1);
        map1.showMap();
        map1.putBoat(0, 0);
        map1.putBoat(0, 1);
        map1.putBoat(0, 2);
        map1.showMap();

        Player bot = new Player("Bot");
        Map map2 = new Map(bot);
        bot.setMap(map2);
        map2.showMap();
    }
}
