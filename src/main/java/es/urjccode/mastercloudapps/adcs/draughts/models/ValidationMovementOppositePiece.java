package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationMovementOppositePiece extends ValidationMovement {

    ValidationMovementOppositePiece(Game game) {
        super(game);
    }
    
    @Override
    public Error handleValidation(Coordinate origin, Coordinate target) {
        
        Color color = this.getGame().getBoard().getColor(origin);
        if (this.getGame().getTurnColor() != color) {
            return Error.OPPOSITE_PIECE;
        }
        
        return this.handleNext(origin, target);
    }
}
