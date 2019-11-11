package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationMovementEmptyOrigin extends ValidationMovement {

    ValidationMovementEmptyOrigin(Game game) {
        super(game);
    }
    
    @Override
    public Error handleValidation(Coordinate origin, Coordinate target) {
        
        if (this.getGame().getBoard().isEmpty(origin))
            return Error.EMPTY_ORIGIN;
        
        return this.handleNext(origin, target);
    }
}
