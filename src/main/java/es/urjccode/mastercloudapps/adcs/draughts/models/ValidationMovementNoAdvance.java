package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationMovementNoAdvance extends ValidationMovement {

    ValidationMovementNoAdvance(Game game) {
        super(game);
    }
    
    @Override
    public Error handleValidation(Coordinate origin, Coordinate target) {
        
        Piece piece = this.getGame().getBoard().getPiece(origin);
        if (!piece.isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }
        
        return this.handleNext(origin, target);
    }
}
