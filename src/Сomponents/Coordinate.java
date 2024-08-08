package Сomponents;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int pointX, int pointY){
        this.x = pointX;
        this.y = pointY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate other = (Coordinate) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }
}
