/**
 * Project: homework08
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 04.01.2023 03:51 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Player nikita = new Player("Nikita");
        Ship boat = new Ship(Ship.name1, 1, nikita);
        Ship destroyer = new Ship(Ship.name2, 2, nikita);
        Ship cruiser = new Ship(Ship.name3, 3, nikita);
        Ship battleship = new Ship( Ship.name4, 4, nikita);
        Map map1 = new Map(nikita);
        nikita.setMap(map1);
        map1.showMap();
        map1.putBoat(0,0);
        map1.putBoat(0,1);
        map1.putBoat(0,2);
        map1.showMap();

        Player bot = new Player("Bot");
        Ship boat2 = new Ship(Ship.name1, 1, bot);
        Ship destroyer2 = new Ship(Ship.name2, 2, bot);
        Ship cruiser2 = new Ship(Ship.name3, 3, bot);
        Ship battleship2 = new Ship( Ship.name4, 4, bot);
        Map map2 = new Map(bot);
        bot.setMap(map2);
        map2.showMap();


//        System.out.println(nikita.shoot(1,2));
//        System.out.println("Имя игрока - " + bot.getName());
//        bot.setName("alyosha");
//        System.out.println("Имя игрока - " + bot.getName());
//        System.out.println("счёт игрока " + nikita.getName() + " - " + nikita.getShore());
//        nikita.upShore();
//        System.out.println("счёт игрока " + nikita.getName() + " - " + nikita.getShore());

//        System.out.println("Имя судна - " + boat.getName() + "; Размер судна - " + boat.getSize());
//        System.out.println("Имя судна - " + destroyer.getName() + "; Размер судна - " + destroyer.getSize());
//        System.out.println("Имя судна - " + cruiser.getName() + "; Размер судна - " + cruiser.getSize());
//        System.out.println("Имя судна - " + battleship.getName() + "; Размер судна - " + battleship.getSize());
    }
}

