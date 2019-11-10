package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class PlayView extends SubView {

    private GameView gameView;
    
    public PlayView() {
        super();
        this.gameView = new GameView();
    }

    public void interact(PlayController playController) {
        String color = ColorView.values()[playController.getColor().ordinal()].getMessage();
        Error error;
        
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            error = playController.move(Coordinate.origin(command), Coordinate.target(command));
            this.evaluateMessageError(error, playController);
        } while (error != null);
        
        this.evaluateMessageEndGame(playController);
    }
    
    private void evaluateMessageError(Error error, PlayController playController) {
        if (error != null) {
            this.console.writeln("Error!!!" + error.name());
            this.gameView.write(playController);
        }
    }
    
    private void evaluateMessageEndGame(PlayController playController) {
        if (playController.isBlocked()) {
            MessageView.LOSE.write();
        }
    }
}