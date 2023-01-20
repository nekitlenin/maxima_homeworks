package cars;

/**
 * Project: homework10
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 18.01.2023 14:14 |
 * Created with IntelliJ IDEA
 */
public class Car {
    protected String country;
    private String model;
    private int price;
    private String color;
    private int width; // ширина
    private int height; // высота
    private int length; // длина
    private int weigh; // вес

    protected Car(String model, int price, String color, int width, int height, int length, int weigh) {
        this.model = model;
        this.price = price;
        this.color = color;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weigh = weigh;
    }

    protected void ride() {
        System.out.println("Автомобиль не едет");
    }

    protected void brake() {
        System.out.println("Эффективность торможения - 0%");
    }

    protected void takeFuel() {
        System.out.println("Не удалось заправиться топливом! Ознакомьтесь со справочником автомобиля!");
    }

    protected String getModel() {
        return model;
    }

    protected void setModel(String model) {
        this.model = model;
    }

    protected int getPrice() {
        return price;
    }

    protected void setPrice(int price) {
        this.price = price;
    }

    protected String getColor() {
        return color;
    }

    protected void setColor(String color) {
        this.color = color;
    }

    protected int getWidth() {
        return width;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected int getHeight() {
        return height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }

    protected int getLength() {
        return length;
    }

    protected void setLength(int length) {
        this.length = length;
    }

    protected int getWeigh() {
        return weigh;
    }

    protected void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    protected String getCountry() {
        return country;
    }

    protected void setCountry(String country) {
        this.country = country;
    }
}
