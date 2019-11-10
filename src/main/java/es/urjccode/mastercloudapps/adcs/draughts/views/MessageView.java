package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public enum MessageView {
    
    TITLE("Draughts");
    
    private final String message;
    private final Console console;
    
    private MessageView(String message) {
        this.message = message;
        this.console = new Console();
    }
    
    public void write() {
        this.console.write(this.message);
    }
    
    public void writeln() {
        this.console.writeln(this.message);
    }
}
