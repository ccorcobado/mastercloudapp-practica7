package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class GameView {

    protected PieceView pieceView;
    
    public GameView() {
        this.pieceView = new PieceView();
    }

    public void write(Controller controller) {
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        for (int i = 0; i < DIMENSION; i++) {
            this.pieceView.writeNumber(i + 1);
            for (int j = 0; j < DIMENSION; j++) {
                Color color = controller.getColor(new Coordinate(i, j));
                this.pieceView.writeShort(color);
            }
            this.pieceView.writelnNumber(i + 1);
        }
        this.writeNumbersLine(DIMENSION);
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.pieceView.writeShort(null);
        for (int i = 0; i < DIMENSION; i++) {
            this.pieceView.writeNumber(i + 1);
        }
        this.pieceView.writeln();
    }

}
