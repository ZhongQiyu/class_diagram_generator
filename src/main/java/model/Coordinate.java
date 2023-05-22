package model;

/**
 A Java class that defines the position, by way of
 x-y coordinates, for the model.
 @author Brendan Pritikin, Qiyu 'Allen' Zhong, Tyler Nass
 @version 1.0
 */
public class Coordinate {
    private double x, y;

    /**
     *  sets coordinates x and y.
     * @param x x-axis coordinate.
     * @param y y-axis coordinate.
     */
    public Coordinate(int x, int y){
        this.x = (double) x;
        this.y = (double) y;
    }

    /**
     * Use data of type double to set the coordinates.
     * @param x x-axis coordinate.
     * @param y y-axis coordinate.
     */
    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     *  gets x-coordinate, returns.
     * @return x-coordainte
     */
    public double getX() {
        return x;
    }

    /**
     * gets y-coordinate, returns.
     * @return y-coordinate
     */
    public double getY(){
        return y;
    }

    /**
     *  sets x-coordinate.
     * @param x desired x-coordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *  sets y-coordinate.
     * @param y desired y-coordiante.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return a complete representation of a Coordinate.
     */
    public String getInfo(){
        return "Coordinate: (" + x + ", " + y + ")\n";
    }

    /**
     * @return a partial representation of a Coordinate.
     */
    public String toString(){
        return "(" + x + ", " + y + ")";
    }

    /**
     * Compare if two Coordinate objects are the same.
     * @param o the other object to compare with.
     * @return true if both represents the same information, false otherwise.
     */
    public boolean equals(Object o){
        if (o.getClass() == Coordinate.class){
            return this.getX() == ((Coordinate) o).getX() && this.getY() == ((Coordinate) o).getY();
        } else {
            return false;
        }
    }

    /**
     * Compute the slope of the line that connects the current coordinate and another one.
     * @param other the other coordinate to which the line connects.
     * @return the slope of this connection.
     */
    public double getSlope(Coordinate other){
        return (other.getY()-this.getY())/(other.getX()-this.getX());
    }
}
