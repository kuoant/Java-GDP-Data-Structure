class Point {

    double x;
    double y;


    /**
     * Erzeugt ein neues Objekt mit den Koordinaten x und y
     */
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gibt die x-Koordinate zurück
     */
    double getX() {
        return this.x;
    }

    /**
     * Gibt die y-Koordinate zurück
     */
    double getY() {
        return this.y;
    }

    public static void main(String[] args) {
        Point diese = new Point(4,5);
        System.out.println(diese.getX());
    }

}
