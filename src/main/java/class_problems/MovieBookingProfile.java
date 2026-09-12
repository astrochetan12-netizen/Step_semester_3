public class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    public MovieBookingProfile() {
    }

    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public void setOtp(String otp) {
        if (otp != null) {
            this.otp = "HASH:" + otp.hashCode();
        }
    }

    public static void main(String[] args) {
        MovieBookingProfile p1 = new MovieBookingProfile("Rahul Dev");
        System.out.println("Profile Name: " + p1.getName());

        p1.setConfirmed(true);
        System.out.println("isConfirmed: " + p1.isConfirmed());

        p1.setOtp("4471");
        System.out.println("OTP set successfully (write-only property verified).");
    }
}