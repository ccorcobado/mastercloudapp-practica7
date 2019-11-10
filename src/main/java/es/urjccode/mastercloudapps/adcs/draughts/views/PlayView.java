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
            String origin = command.substring(0, 2);
            String target = command.substring(3, 5);
            error = playController.move(new Coordinate(origin), new Coordinate(target));
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