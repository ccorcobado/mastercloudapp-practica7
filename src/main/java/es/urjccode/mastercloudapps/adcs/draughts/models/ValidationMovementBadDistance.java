package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationMovementBadDistance extends ValidationMovement {

    ValidationMovementBadDistance(Game game) {
        super(game);
    }
    
    @Override
    public Error handleValidation(Coordinate origin, Coordinate target) {
        
        if (origin.diagonalDistance(target) >= 3) {
            return Error.BAD_DISTANCE;
        }
        
        return this.handleNext(origin, target);
    }
}
