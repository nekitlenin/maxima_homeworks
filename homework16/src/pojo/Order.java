package pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: homework16
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 21.02.2023 14:46 |
 * Created with IntelliJ IDEA
 */
public class Order {
    long id;
    String name;
    List<Item> itemList;
    LocalDateTime createDate;

    public Order(long id, String name, List<Item> itemList, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.itemList = itemList;
        this.createDate = createDate;
    }

    public static List<Order> makeOrderList() {
        Item ipad = new Item(1, "ipad");
        Item iphone = new Item(2, "iphone");
        Item imac = new Item(3, "imac");
        Item macbook = new Item(4, "macbook");
        Item airpods = new Item(5, "airpods");

        List<Item> itemList1 = new ArrayList<>();
        itemList1.add(ipad);
        itemList1.add(macbook);

        List<Item> itemList2 = new ArrayList<>();
        itemList2.add(iphone);
        itemList2.add(airpods);

        List<Item> itemList3 = new ArrayList<>();
        itemList3.add(imac);
        itemList3.add(airpods);
        itemList3.add(iphone);

        Order nikita = new Order(1, "Nikita", itemList1,
                LocalDateTime.of(2000, 8, 16, 21, 33));
        Order bob = new Order(1, "Bob", itemList2,
                LocalDateTime.of(2007, 10, 10, 2, 3));
        Order lucy = new Order(1, "Lucy", itemList3,
                LocalDateTime.of(2020, 10, 10, 2, 3));

        List<Order> orders = new ArrayList<>();
        orders.add(nikita);
        orders.add(bob);
        orders.add(lucy);

        return orders;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemList=" + itemList +
                ", createDate=" + createDate.toString() +
                '}';
    }
}
