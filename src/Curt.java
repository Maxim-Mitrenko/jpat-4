import java.util.Map;

public interface Curt {

    public void add(Item item, int count);

    public Map<Item, Integer> get();

    public boolean isEmpty();
}