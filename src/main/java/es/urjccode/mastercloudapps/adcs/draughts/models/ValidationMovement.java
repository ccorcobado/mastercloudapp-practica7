package es.urjccode.mastercloudapps.adcs.draughts.models;

public abstract class ValidationMovement {

    private final Game game;
    protected ValidationMovement nextSuccesor;
    protected Error errorResult;

    protected ValidationMovement(Game game) {
        this.game = game;
        this.errorResult = null;
        this.nextSuccesor = null;
    }

    public abstract Error handleValidation(Coordinate origin, Coordinate target);
    
    protected Game getGame() {
        return this.game;
    }
    
    protected Error handleNext(Coordinate origin, Coordinate target) {
        if (this.nextSuccesor != null)
            return this.nextSuccesor.handleValidation(origin, target);
        
        return this.errorResult;
    }

    public void setSuccessor(ValidationMovement successor) {
        this.nextSuccesor = successor;
    }
}
