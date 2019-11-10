package es.urjccode.mastercloudapps.adcs.draughts.models;

class Square {

    private Piece piece;

    Square() { }

    void put(Piece piece) {
        this.piece = piece;
    }

    Piece remove() {
        Piece newpiece = this.piece;
        put(null);
        return newpiece;
    }

    Piece getPiece() {
        return this.piece;
    }

    public boolean isEmpty() {
        return this.getPiece() == null;
    }

    public Color getColor() {
        if (this.getPiece() == null) {
            return null;
        }
        return this.getPiece().getColor();
    }

}
