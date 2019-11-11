package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationMovementNoDiagonal extends ValidationMovement {

    ValidationMovementNoDiagonal(Game game) {
        super(game);
    }
    
    @Override
    public Error handleValidation(Coordinate origin, Coordinate target) {
        
        if (!origin.isDiagonal(target)) {
            return Error.NOT_DIAGONAL;
        }
        
        return this.handleNext(origin, target);
    }
}
