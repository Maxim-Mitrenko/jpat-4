import java.util.Comparator;

public class Item implements Comparable<Item> {

    protected String name;
    protected int price;
    protected Seller seller;
    protected static Comparator<Item> comparator = Comparator.comparingInt(o -> o.price);

    public Item(String name, int price, Seller seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
        seller.addItem(this);
    }

    public void setComparator(Comparator<Item> comparator) {
        Item.comparator = comparator;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Item o) {
        return comparator.compare(this, o);
    }

    @Override
    public String toString() {
        return name + " " + price + " рублей";
    }
}