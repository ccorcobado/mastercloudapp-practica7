package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import java.util.HashMap;
import java.util.Map;

import es.urjccode.mastercloudapps.adcs.draughts.models.Session;
import es.urjccode.mastercloudapps.adcs.draughts.models.StateValue;

public class Logic {

    private final Session session;
    private final StartController startController;
    private final PlayController playController;
    private final ResumeController resumeController;
    private final Map<StateValue, Controller> controllers;

    public Logic() {
        this.session = new Session();
        this.controllers = new HashMap<>();
        this.startController = new StartController(this.session);
        this.playController = new PlayController(this.session);
        this.resumeController = new ResumeController(this.session);
        
        this.controllers.put(StateValue.INITIAL, this.startController);
        this.controllers.put(StateValue.IN_GAME, this.playController);
        this.controllers.put(StateValue.FINAL, this.resumeController);
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.session.getValueState());
    }
}