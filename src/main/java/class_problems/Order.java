package class_problems;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> items;
    private String status;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new HashMap<>();
        this.status = "Pending";
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public boolean processPayment(PaymentMethod paymentMethod) {
        if (isEmpty()) {
            System.out.println("Cannot process payment for an empty order.");
            return false;
        }

        System.out.println("Payment initiated via " + paymentMethod.getName() + " for " + orderId + ".");
        boolean success = paymentMethod.processPayment(calculateTotal());
        if (success) {
            this.status = "Paid";
            System.out.println("Payment for " + orderId + " successful. Order status: " + this.status + ".");
        } else {
            System.out.println("Payment for " + orderId + " failed. Order status: " + this.status + ".");
        }
        return success;
    }
}
