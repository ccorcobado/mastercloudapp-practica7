package es.urjccode.mastercloudapps.adcs.draughts.models;

public class State {

    private StateValue stateValue;

    public State() {
        this.reset();
    }

    public StateValue getValueState() {
        return this.stateValue;
    }
    
    void setStateValue(StateValue stateValue) {
        this.stateValue = stateValue;
    }
    
    public void next() {
        assert this.getValueState() != StateValue.EXIT;
        this.setStateValue(StateValue.values()[this.getValueState().ordinal() + 1]);
    }

    public void reset() {
        this.setStateValue(StateValue.INITIAL);
    }
}
