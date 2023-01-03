/**
 * Project: homework07
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 02.01.2023 01:26 |
 * Created with IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        Player nikita = new Player("Nikita");
        Player bot = new Player("Bot");
        Ship boat = new Ship( 1, "Boat");
        Ship destroyer = new Ship( 2, "Destroyer");
        Ship cruiser = new Ship( 3, "Cruiser");
        Ship battleship = new Ship( 4, "Battleship");


        System.out.println(nikita.shoot(1,2));
        System.out.println("Имя игрока - " + bot.getName());
        bot.setName("alyosha");
        System.out.println("Имя игрока - " + bot.getName());
        System.out.println("счёт игрока " + nikita.getName() + " - " + nikita.getShore());
        nikita.upShore();
        System.out.println("счёт игрока " + nikita.getName() + " - " + nikita.getShore());

        System.out.println("Имя судна - " + boat.getName() + "; Размер судна - " + boat.getSize());
        System.out.println("Имя судна - " + destroyer.getName() + "; Размер судна - " + destroyer.getSize());
        System.out.println("Имя судна - " + cruiser.getName() + "; Размер судна - " + cruiser.getSize());
        System.out.println("Имя судна - " + battleship.getName() + "; Размер судна - " + battleship.getSize());
    }
}
