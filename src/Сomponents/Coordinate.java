package Сomponents;

import java.util.Objects;

public class Coordinate {
    private int pointX;
    private int pointY;

    public Coordinate(int pointX, int pointY){
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate other = (Coordinate) obj;
        return pointX == other.pointX && pointY == other.pointY;
    }

    @Override
    public int hashCode(){
        return Objects.hash(pointX, pointY);
    }
}
