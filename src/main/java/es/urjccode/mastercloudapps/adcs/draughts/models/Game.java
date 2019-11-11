package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Game {

    private final Board board;
    private final Turn turn;

    public Game() {
        this.turn = new Turn();
        this.board = new BoardBuilder()
                .buildTop(Color.BLACK)
                .buildBottom(Color.WHITE)
                .toBoard();  
    }

    Board getBoard() {
        return this.board;
    }
    
    Turn getTurn() {
        return this.turn;
    }
    
    public Error move(Coordinate origin, Coordinate target) {
        assert origin != null && target != null;
        
        ValidationMovementContext movementContext = new ValidationMovementContext(this);
        Error error = movementContext.validate(origin, target);
        
        if (error == null) {
            this.getBoard().move(origin, target);
            this.getTurn().change();
            return null;
        }
        else
            return error;
    }

    public Color getColor(Coordinate coordinate) {
        return this.getBoard().getColor(coordinate);
    }

    public Color getTurnColor() {
        return this.getTurn().getColor();
    }
    
    @Override
    public String toString() {
        return this.getBoard() + "\n" + this.getTurn();
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.getBoard().getPiece(coordinate);
    }

    public boolean isBlocked() {
        return this.getBoard().getPieces(this.getTurnColor()).isEmpty();
    }

    public int getDimension() {
        return this.getBoard().getDimension();
    }
}
