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
//        if (!origin.isValid() || !target.isValid()) {
//            return Error.OUT_COORDINATE;
//        }
        if (this.getBoard().isEmpty(origin)) {
            return Error.EMPTY_ORIGIN;
        }
        Color color = this.getBoard().getColor(origin);
        if (this.getTurn().getColor() != color) {
            return Error.OPPOSITE_PIECE;
        }
        if (!origin.isDiagonal(target)) {
            return Error.NOT_DIAGONAL;
        }
        Piece piece = this.getBoard().getPiece(origin);
        if (!piece.isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }
        if (origin.diagonalDistance(target) >= 3) {
            return Error.BAD_DISTANCE;
        }
        if (!this.getBoard().isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        if (origin.diagonalDistance(target) == 2) {
            Coordinate between = origin.betweenDiagonal(target);
            if (this.getBoard().getPiece(between) == null) {
                return Error.EATING_EMPTY;
            }
            this.getBoard().remove(between);
        }
        this.getBoard().move(origin, target);
        this.getTurn().change();
        return null;
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
