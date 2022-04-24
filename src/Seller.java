import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Seller {

    protected String name;
    protected List<Item> items;

    public Seller(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
        Collections.sort(items);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n" + "Товары: ");
        for (Item item : items) {
            sb.append("\n" + item);
        }
        return sb.toString();
    }
}