package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class PlayView extends SubView {

    public PlayView() {
        super();
    }

    public void interact(PlayController playController) {
        String color = ColorView.values()[playController.getColor().ordinal()].getMessage();
        Error error;
        GameView gameView = new GameView();
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            error = playController.move(Coordinate.origin(command), Coordinate.target(command));
            if (error != null) {
                this.console.writeln("Error!!!" + error.name());
                gameView.write(playController);
            }
        } while (error != null);
        
        if (playController.isBlocked()) {
            MessageView.LOSE.write();
        }
    }
}