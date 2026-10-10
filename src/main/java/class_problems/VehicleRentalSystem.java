package class_problems;

public class VehicleRentalSystem {
    public Rental rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getModel() + " is currently unavailable.");
            return null;
        }
        vehicle.setAvailable(false);
        Rental rental = new Rental(customer, vehicle, days);
        System.out.println(vehicle.getModel() + " rented successfully by " + customer.getName() + ". Rental charge: $" + rental.getTotalCharge() + ".");
        return rental;
    }

    public void returnVehicle(Customer customer, Vehicle vehicle) {
        vehicle.setAvailable(true);
        System.out.println(vehicle.getModel() + " returned by " + customer.getName() + ".");
    }

    public static void main(String[] args) {
        VehicleRentalSystem system = new VehicleRentalSystem();

        Customer customer1 = new Customer("Customer 1");
        Customer customer2 = new Customer("Customer 2");
        Customer customer3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A", 50.0);
        Vehicle suvB = new SUV("SUV B", 80.0);

        system.rentVehicle(customer1, sedanA, 3);
        system.rentVehicle(customer2, sedanA, 2);
        system.returnVehicle(customer1, sedanA);
        system.rentVehicle(customer3, suvB, 5);
    }
}
