import java.util.Map;

@FunctionalInterface
public interface Calculator {

    public int calculate(Map<Item, Integer> map);
}