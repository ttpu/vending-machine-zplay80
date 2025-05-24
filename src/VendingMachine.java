import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Map<String, Double> beverages = new HashMap<>();
    private Map<Integer, Double> cards = new HashMap<>();
    private Column[] columns = new Column[4];

    public VendingMachine() {
        for (int i = 0; i < 4; i++) {
            columns[i] = new Column();
        }
    }

    public void addBeverage(String name, double price) {
        beverages.put(name, price);
    }

    public double getPrice(String beverageName) {
        return beverages.getOrDefault(beverageName, -1.0);
    }

    public void rechargeCard(int cardId, double credit) {
        cards.put(cardId, cards.getOrDefault(cardId, 0.0) + credit);
    }

    public double getCredit(int cardId) {
        return cards.getOrDefault(cardId, -1.0);
    }

    public void refillColumn(int column, String beverageName, int cans) {
        int index = column - 1;
        columns[index].beverageName = beverageName;
        columns[index].cans = cans;
    }

    public int availableCans(String beverageName) {
        int total = 0;
        for (Column col : columns) {
            if (col.beverageName != null && col.beverageName.equals(beverageName)) {
                total += col.cans;
            }
        }
        return total;
    }

    public int sell(String beverageName, int cardId) {
        double price = getPrice(beverageName);
        if (price == -1.0) {
            return -1;
        }
        if (availableCans(beverageName) == 0) {
            return -1;
        }
        double credit = getCredit(cardId);
        if (credit < price) {
            return -1;
        }
        for (int i = 0; i < 4; i++) {
            Column col = columns[i];
            if (col.beverageName != null && col.beverageName.equals(beverageName) && col.cans > 0) {
                col.cans--;
                cards.put(cardId, credit - price);
                return i + 1;
            }
        }
        return -1;
    }

    private static class Column {
        String beverageName;
        int cans;
    }
}