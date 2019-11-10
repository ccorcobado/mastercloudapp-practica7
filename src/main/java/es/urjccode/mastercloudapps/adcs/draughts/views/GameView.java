package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class GameView extends SubView {

    public void write(Controller controller) {
        final int DIMENSION = controller.getDimension();
        
        this.writeNumbersLine(DIMENSION);
        for (int i = 0; i < DIMENSION; i++) {
            this.console.write(String.valueOf(i + 1));
            for (int j = 0; j < DIMENSION; j++) {
                Color color = controller.getColor(new Coordinate(i, j));
                this.console.write(ColorView.valueOf(color).getPieceMessage());
            }
            this.console.writeln(String.valueOf(i + 1));
        }
        this.writeNumbersLine(DIMENSION);
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(ColorView.EMPTY.getPieceMessage());
        for (int i = 0; i < DIMENSION; i++)
            this.console.write(String.valueOf(i + 1));
        
        this.console.writeln();
    }

}
