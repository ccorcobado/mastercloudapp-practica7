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

    int sumDiagonal() {
        return this.getRow() + this.getColumn();
    }
    
    int diffDiagonal() {
        return this.getRow() - this.getColumn();
    }
    
    int diffRow(Coordinate coordinate) {
        return this.getRow() - coordinate.getRow();
    }
    
    private void assertCoordinate(Coordinate coordinate) {
        assert coordinate != null && coordinate.isValid();
    }
    
    public boolean isDiagonal(Coordinate coordinate) {
        assertCoordinate(coordinate);
        assertCoordinate(this);
        return this.sumDiagonal() == coordinate.sumDiagonal() || this.diffDiagonal() == coordinate.diffDiagonal();
    }

    public int diagonalDistance(Coordinate coordinate) {
        assertCoordinate(coordinate);
        assertCoordinate(this);
        assert this.isDiagonal(coordinate);
        return Math.abs(this.getRow() - coordinate.getRow());
    }

    public Coordinate betweenDiagonal(Coordinate coordinate) {
        assert coordinate != null && coordinate.isValid();
        assert this.isValid() && this.diagonalDistance(coordinate) == 2;
        int rowShift = 1;
        if (coordinate.getRow() - this.getRow() < 0) {
            rowShift = -1;
        }
        int columnShift = 1;
        if (coordinate.getColumn() - this.getColumn() < 0) {
            columnShift = -1;
        }
        return new Coordinate(this.getRow() + rowShift, this.getColumn() + columnShift);
    }

    public boolean isBlack() {
        assert this.isValid();
        return (this.getRow() + this.getColumn()) % 2 != 0;
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
