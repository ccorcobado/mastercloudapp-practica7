package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Session;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class GameViewTest {
    
    @Mock
    Console console;
    
    @Mock
    PieceView pieceView;

    @InjectMocks
    GameView gameView;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Captor
    ArgumentCaptor<String> argument;
    
    @Test
    public void testInteract(){
        StartController startController = new StartController(new Session());
        this.gameView.write(startController);
        verify(this.pieceView, times(IndexNumber(24))).writeNumber(anyInt());
        verify(this.pieceView, times(NumberOfPiecesPerColor(12))).shortWrite(Color.BLACK);
        verify(this.pieceView, times(NumberOfPiecesPerColor(12))).shortWrite(Color.WHITE);
        verify(this.pieceView, times(EmptyNumber(42))).shortWrite(null);
        
//        List<String> rows = Arrays.asList(
//        " 12345678",
//        "1 n n n n",
//        "2n n n n ",
//        "3 n n n n",
//        "4        ",
//        "5        ",
//        "6b b b b ",
//        "7 b b b b",
//        "8b b b b ",
//        " 12345678");
//        assertEquals(marshall(rows), marshall(argument.getAllValues()));
    }

    private static int IndexNumber(int indexNumber) {
        return indexNumber;
    }
    
    private static int NumberOfPiecesPerColor(int numberOfPiecesPerColor) {
        return numberOfPiecesPerColor;
    }
    
    private static int EmptyNumber(int emptyNumber) {
        return emptyNumber;
    }
    
//    private static String marshall(List<String> strings){
//        String string = "";
//        Iterator<String> iterator = strings.iterator();
//        while (iterator.hasNext()){
//            string += iterator.next();
//        }
//        return string;
//    }

}