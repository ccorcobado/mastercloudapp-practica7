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

    public Error move(Coordinate origin, Coordinate target) {
        assert origin != null && target != null;
        if (!origin.isValid() || !target.isValid()) {
            return Error.OUT_COORDINATE;
        }
        if (board.isEmpty(origin)) {
            return Error.EMPTY_ORIGIN;
        }
        Color color = this.board.getColor(origin);
        if (this.turn.getColor() != color) {
            return Error.OPPOSITE_PIECE;
        }
        if (!origin.isDiagonal(target)) {
            return Error.NOT_DIAGONAL;
        }
        Piece piece = this.board.getPiece(origin);
        if (!piece.isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }
        if (origin.diagonalDistance(target) >= 3) {
            return Error.BAD_DISTANCE;
        }
        if (!this.board.isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        if (origin.diagonalDistance(target) == 2) {
            Coordinate between = origin.betweenDiagonal(target);
            if (this.board.getPiece(between) == null) {
                return Error.EATING_EMPTY;
            }
            this.board.remove(between);
        }
        this.board.move(origin, target);
        this.turn.change();
        return null;
    }

    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

    public Color getTurn() {
        return this.turn.getColor();
    }
    
    @Override
    public String toString() {
        return this.board + "\n" + this.turn;
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.board.getPiece(coordinate);
    }

    public boolean isBlocked() {
        return this.board.getPieces(this.turn.getColor()).isEmpty();
    }

    public int getDimension() {
        return this.board.getDimension();
    }
}
