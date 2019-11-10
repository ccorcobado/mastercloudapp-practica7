package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.Session;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class PlayControllerTest {

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        PlayController playController = new PlayController(new Session());
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }
    
    @Test()
    public void testGivenPlayControllerWhenMoveWithOuterCoordinateThenOutCoordinateError() {
        PlayController playController = new PlayController(new Session());
        Coordinate origin = new Coordinate(4, 7);
        Coordinate target = new Coordinate(3, 8);
        
        assertEquals(Error.OUT_COORDINATE, playController.move( origin, target));
    }

    // public void data(){
    //     Coordinate[][] coordinates = new Coordinate[][] {
    //         { new Coordinate(0,0), new Coordinate(0,0) },
    //         { new Coordinate(0,0), new Coordinate(0,0), new Coordinate(0,0), new Coordinate(0,0) },
    //         { new Coordinate(0,0), new Coordinate(0,0) },
    //     };

        // peon mueve una
        // peon come una
        // peon come varias
        // peon se convierte en dama
        // dama mueve una
        // dama mueve varias
        // dama come una
        // dama come varias, atras

    //}


}
