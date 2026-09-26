public class DeliveryDrone extends Drone implements Trackable {

    public DeliveryDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return "Delivery drone flying";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }

    public static void main(String[] args) {
        DeliveryDrone d = new DeliveryDrone("DR-1");
        ScoutDrone s = new ScoutDrone("SC-1");
        GroundRobot g = new GroundRobot("GR-1");

        System.out.println(Trackable.getLocationIfTrackable(d));
        System.out.println(Trackable.getLocationIfTrackable(s));
        System.out.println(Trackable.getLocationIfTrackable(g));
    }
}