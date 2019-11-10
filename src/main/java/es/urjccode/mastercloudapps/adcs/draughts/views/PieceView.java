package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public class PieceView {
    
    private static final String BLACKS_VIEW = "negras";
    private static final String WHITES_VIEW = "blancas";
    
    protected Console console;
    
    public PieceView() {
        this.console = new Console();
    }
    
    public String getLongMessage(Color color) {
        if (color == null)
            return " ";
        
        if (color == Color.BLACK)
            return BLACKS_VIEW;
        else 
            return WHITES_VIEW;
    }
    
    public String getShortMessage(Color color) {
        return new String(new char[] { this.getLongMessage(color).charAt(0) });
    }
    
    public void writeLong(Color color) {
        this.console.write(this.getLongMessage(color));
    }
    
    public void writelnLong(Color color) {
        this.console.writeln(this.getLongMessage(color));
    }
    
    public void writeShort(Color color) {
        this.console.write(this.getShortMessage(color));
    }
    
    public void writelnShort(Color color) {
        this.console.writeln(this.getShortMessage(color));
    }
    
    public void writeln() {
        this.console.writeln();
    }
    
    private void assertNumber(int number) {
        assert number >= 1 && number <= 8;
    }
    
    public void writeNumber(int number) {
        assertNumber(number);
        this.console.write(String.valueOf(number));
    }
    
    public void writelnNumber(int number) {
        assertNumber(number);
        this.console.writeln(String.valueOf(number));
    }
}
