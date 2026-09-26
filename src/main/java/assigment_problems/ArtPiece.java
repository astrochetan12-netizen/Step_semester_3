public abstract class ArtPiece {

    private static int counter = 0;
    private final String pieceId;
    protected String title;

    public ArtPiece(String title) {
        counter++;
        this.pieceId = "ART-" + counter;
        this.title = title;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }
}