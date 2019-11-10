package es.urjccode.mastercloudapps.adcs.draughts.models;

public class BoardBuilder {
    private static final int TOP = 0;
    private static final int MIDDLE_TOP = 3;
    private static final int MIDDLE_BOTTOM = 5;
    private final Board board;
    
    BoardBuilder() {
        this.board = new Board();
    }
    
    private void put(Coordinate coordinate, Color color) {
        if (coordinate.isBlack())
            this.board.put(coordinate, new Piece(color));
    }
    
    private void build(Color color, int init, int end) {
        for (int i = init; i < end; i++) {
            for (int j = 0; j < this.board.getDimension(); j++) {
                Coordinate coordinate = new Coordinate(i, j);
                put(coordinate, color);
            }
        }
    }
    
    BoardBuilder buildTop(Color color) {
        build(color, TOP, MIDDLE_TOP);
        
        return this;
    }
    
    BoardBuilder buildBottom(Color color) {
        build(color, MIDDLE_BOTTOM, this.board.getDimension());
        
        return this;
    }
    
    Board toBoard() {
        return this.board;
    }
}
