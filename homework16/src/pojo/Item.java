package pojo;

/**
 * Project: homework16
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 21.02.2023 14:47 |
 * Created with IntelliJ IDEA
 */
public class Item {
    long id;
    String name;

    public Item(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
