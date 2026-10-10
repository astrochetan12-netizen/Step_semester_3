package class_problems;

public class ShoppingSystem {
    public Order createOrder(String orderId, Customer customer) {
        Order order = new Order(orderId, customer);
        return order;
    }

    public static void main(String[] args) {
        ShoppingSystem system = new ShoppingSystem();

        Customer customerX = new Customer("Customer X");
        Customer customerY = new Customer("Customer Y");
        Customer customerZ = new Customer("Customer Z");

        Product productA = new Product("Product A", 50.0);
        Product productB = new Product("Product B", 30.0);
        Product productC = new Product("Product C", 40.0);

        Order orderX = system.createOrder("Order X", customerX);
        orderX.addProduct(productA, 2);
        orderX.addProduct(productB, 1);
        System.out.println("Order created for " + customerX.getName() + ".");
        orderX.processPayment(new CreditCardPayment());

        Order orderY = system.createOrder("Order Y", customerY);
        orderY.processPayment(new CreditCardPayment());

        Order orderZ = system.createOrder("Order Z", customerZ);
        orderZ.addProduct(productC, 1);
        System.out.println("Order created for " + customerZ.getName() + ".");
        orderZ.processPayment(new PayPalPayment(false));
    }
}
