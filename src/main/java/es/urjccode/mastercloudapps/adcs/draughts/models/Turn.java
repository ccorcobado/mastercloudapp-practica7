package es.urjccode.mastercloudapps.adcs.draughts.models;

class Turn {

    private Color color;

    Turn() {
        this.color = Color.WHITE;
    }

    void change() {
        this.color = Color.values()[(this.getColor().ordinal() + 1) % 2];
    }

    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return this.color.name();
    }
}
