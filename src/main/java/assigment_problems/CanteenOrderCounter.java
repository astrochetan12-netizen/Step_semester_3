package assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class CanteenOrderCounter {
    public static class PopularItemResult {
        private String item;
        private int count;

        public PopularItemResult(String item, int count) {
            this.item = item;
            this.count = count;
        }

        public String getItem() {
            return item;
        }

        public int getCount() {
            return count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    public static PopularItemResult mostPopular(String[] orders) {
        if (orders == null || orders.length == 0) {
            return new PopularItemResult("", 0);
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String order : orders) {
            counts.put(order, counts.getOrDefault(order, 0) + 1);
        }

        String bestItem = orders[0];
        int maxCount = 0;

        for (String order : orders) {
            int count = counts.get(order);
            if (count > maxCount) {
                maxCount = count;
                bestItem = order;
            }
        }

        return new PopularItemResult(bestItem, maxCount);
    }

    public static void main(String[] args) {
        String[] orders1 = {"dosa", "idli", "vada", "dosa", "idli", "dosa", "tea"};
        System.out.println(mostPopular(orders1));

        String[] orders2 = {"tea", "coffee", "coffee", "tea"};
        System.out.println(mostPopular(orders2));
    }
}
