import java.util.*;

public class Shop implements SellItems, Curt, Calculator, PayService, SellersService {

    protected Seller seller = new Seller("Рога и Копыта");
    protected List<Item> items = new ArrayList<>(Arrays.asList(
            new Item("Молоко", 50,seller),
            new Item("Соль", 30, seller),
            new Item("Хлеб", 40, seller)));
    protected Map<Item, Integer> buys = new TreeMap<>();
    protected PayService payService;

    public Shop(PayService payService) {
        this.payService = payService;
    }

    @Override
    public int calculate(Map<Item, Integer> map) {
        int sum = 0;
        for (Map.Entry<Item, Integer> entry : buys.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    @Override
    public void add(Item item, int count) {
        buys.put(item, count);
    }

    @Override
    public Map<Item, Integer> get() {
        Map<Item, Integer> buys = this.buys;
        this.buys = new TreeMap<>();
        return buys;
    }

    @Override
    public boolean isEmpty() {
        return buys.isEmpty();
    }

    @Override
    public void pay(int sum) {
        payService.pay(sum);
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    public void setPayService(PayService payService) {
        this.payService = payService;
    }

    public void buy() {
        pay(calculate(get()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append((i + 1) + ". " + items.get(i) + "\n");
        }
        return sb.toString();
    }
}