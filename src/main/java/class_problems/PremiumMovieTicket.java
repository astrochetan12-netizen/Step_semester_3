public class PremiumMovieTicket extends MovieTicket {

    public PremiumMovieTicket(String seatNumber, String screenId, double ticketPrice, String movieTitle) {
        super(seatNumber, screenId, ticketPrice, movieTitle);
    }

    public double getDiscountedPrice() {
        return ticketPrice * 0.9;
    }
}