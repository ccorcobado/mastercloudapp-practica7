package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Piece {

    private final Color color;

    Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public boolean isAdvanced(Coordinate origin, Coordinate target) {
        int difference = origin.diffRows(target);
        if (color == Color.WHITE) {
            return difference > 0;
        }
        return difference < 0;
    }

}
