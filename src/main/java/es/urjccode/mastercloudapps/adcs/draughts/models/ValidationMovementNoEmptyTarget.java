package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationMovementNoEmptyTarget extends ValidationMovement {

    ValidationMovementNoEmptyTarget(Game game) {
        super(game);
    }
    
    @Override
    public Error handleValidation(Coordinate origin, Coordinate target) {
        
        if (!this.getGame().getBoard().isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        
        return this.handleNext(origin, target);
    }
}
