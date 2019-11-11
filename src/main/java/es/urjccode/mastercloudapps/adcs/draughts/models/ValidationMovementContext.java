package es.urjccode.mastercloudapps.adcs.draughts.models;

public class ValidationMovementContext {
    
    protected Game game;
    
    ValidationMovementContext(Game game) {
        this.game = game;
    }
    
    public Error Validate(Coordinate origin, Coordinate target) {
        
        ValidationMovementEmptyOrigin emptyOrigin = new ValidationMovementEmptyOrigin(this.game);
        ValidationMovementOppositePiece oppositePiece = new ValidationMovementOppositePiece(this.game);
        ValidationMovementNoDiagonal movementNoDiagonal = new ValidationMovementNoDiagonal(this.game);
        ValidationMovementNoAdvance movementNoAdvance = new ValidationMovementNoAdvance(this.game);
        ValidationMovementBadDistance movementBadDistance = new ValidationMovementBadDistance(this.game);
        ValidationMovementNoEmptyTarget movementNoEmptyTarget = new ValidationMovementNoEmptyTarget(this.game);
        ValidationMovementEatingEmpty movementEatingEmpty = new ValidationMovementEatingEmpty(this.game);
        
        emptyOrigin.setSuccessor(oppositePiece);
        oppositePiece.setSuccessor(movementNoDiagonal);
        movementNoDiagonal.setSuccessor(movementNoAdvance);
        movementNoAdvance.setSuccessor(movementBadDistance);
        movementBadDistance.setSuccessor(movementNoEmptyTarget);
        movementNoEmptyTarget.setSuccessor(movementEatingEmpty);
        
        return emptyOrigin.handleValidation(origin, target);
    }
}
