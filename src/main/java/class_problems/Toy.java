public abstract class Toy {

    private static int counter = 1000;
    private final String toyId;
    protected String name;

    public Toy(String name) {
        counter++;
        this.toyId = "TOY-" + counter;
        this.name = name;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}