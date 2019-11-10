package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Session {

    private final State state;
    private final Game game;

    public Session() {
        this.state = new State();
        this.game = new Game();
    }

    State getState() {
        return this.state;
    }
    
    Game getGame() {
        return this.game;
    }
    
    public StateValue getValueState() {
        return this.getState().getValueState();
    }
    
    public void next() {
        this.getState().next();
    }

    public void reset() {
        this.getState().reset();
    }

    public Error move(Coordinate origin, Coordinate target) {
        return this.getGame().move(origin, target);
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.getGame().getPiece(coordinate);
    }

    public Color getColor() {
        return this.getGame().getColor();
    }

    public Color getColor(Coordinate coordinate) {
        return this.getGame().getColor(coordinate);
    }

    public boolean isBlocked() {
        return this.getGame().isBlocked();
    }

    public int getDimension() {
        return this.getGame().getDimension();
    }
}