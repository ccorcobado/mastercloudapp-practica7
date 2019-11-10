package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public enum ColorView {
    WHITE("blancas"),
    BLACKS("negras"),
    EMPTY(" ");    
    
    private final String message;
    private final Console console;
    
    private ColorView(String message) {
        this.message = message;
        this.console = new Console();
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public String getPieceMessage() {
        return new String(new char[] { this.getMessage().charAt(0) });
    }
    
    public void write() {
        this.console.write(this.message);
    }
    
    public void writeln() {
        this.console.writeln(this.message);
    }
}
