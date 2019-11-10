package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Coordinate {

    private final int row;
    private final int column;
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 7;

    public Coordinate(String format) {
        int number = Integer.parseInt(format);
        this.row = number / 10 - 1;
        this.column = number % 10 - 1;
    }
    
    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    private boolean isInRange(int number) {
        return Coordinate.LOWER_LIMIT <= number && number <= Coordinate.UPPER_LIMIT;
    }
    
    public boolean isValid() {
        return this.isInRange(this.getRow()) && this.isInRange(this.getColumn());
    }

    int sumComponents() {
        return this.getRow() + this.getColumn();
    }
    
    int diffComponents() {
        return this.getRow() - this.getColumn();
    }
    
    int diffRows(Coordinate coordinate) {
        return this.getRow() - coordinate.getRow();
    }
    
    int diffColumns(Coordinate coordinate) {
        return this.getColumn() - coordinate.getColumn();
    }
    
    private void assertCoordinate(Coordinate coordinate) {
        assert coordinate != null && coordinate.isValid();
    }
    
    public boolean isDiagonal(Coordinate coordinate) {
        assertCoordinate(coordinate);
        assertCoordinate(this);
        return this.sumComponents() == coordinate.sumComponents() || this.diffComponents() == coordinate.diffComponents();
    }

    public int diagonalDistance(Coordinate coordinate) {
        assertCoordinate(coordinate);
        assertCoordinate(this);
        assert this.isDiagonal(coordinate);
        
        return Math.abs(this.diffRows(coordinate));
    }

    private int calculateShift(int diffElements) {
        return (diffElements < 0) ? - 1 : 1;
    }
    
    public Coordinate betweenDiagonal(Coordinate coordinate) {
        assertCoordinate(coordinate);
        assertCoordinate(this);
        assert this.diagonalDistance(coordinate) == 2;
        
        int rowShift = calculateShift(coordinate.diffRows(this));
        int columnShift = calculateShift(coordinate.diffColumns(this));
        return new Coordinate(this.getRow() + rowShift, this.getColumn() + columnShift);
    }

    public boolean isBlack() {
        assert this.isValid();
        
        return (this.sumComponents()) % 2 != 0;
    }

    int getRow() {
        return this.row;
    }

    int getColumn() {
        return this.column;
    }

    @Override
    public String toString() {
        return "(" + getRow() + ", " + getColumn() + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getColumn();
        result = prime * result + getRow();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        if (getColumn() != other.getColumn()) {
            return false;
        }
        if (getRow() == other.getRow()) {
        } else {
            return false;
        }
        return true;
    }
    
    private static Coordinate getCoordinateFromCommand(String command, int i, int j) {
        String format = command.substring(i, j);
        return new Coordinate(format);
    }
    
    public static Coordinate origin(String command) {
        return getCoordinateFromCommand(command, 0, 2);
    }
    
    public static Coordinate target(String command) {
        return getCoordinateFromCommand(command, 3, 5);
    }
}
