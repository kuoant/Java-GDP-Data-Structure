
/**
 * Diese Klasse können Sie Nutzen um die Letzte Aufgabe zu lösen,
 * falls Sie die Histogram Aufgabe nicht lösen konnten. Hier werden
 * einfach feste Werte zurückgegeben, die gar nicht von den eingegebenen Daten
 * abhängen.
 */
class MockHistogram {


    /**
     * Erzeugt ein Histogram Objekt für die übergebenen Gleitkommazahlen (daten),
     * mit den angegebenen anzahl Klassen (bins).
     * Die Daten sollen in einem Feld data und die anzahl Klassen in einem Feld
     * numberOfBins gespeichert.
     */
    MockHistogram(double[] data, int numberOfBins) { }

    /**
     * Gibt die Anzahl Klassen (bins) zurück
     */
    int getNumberOfBins() {
        return 7;
    }

    /*
     * gibt die im Histogram gespeicherten Daten zurück
     */
    double[] getData() {
        return null;
    }

    /**
     * Gibt die Grösse einer Klasse (also das Interval zurück). Die Intervallgrösse
     * berechnet sich als (max - min) / #bins, wobei max der Maximalwert in den
     * Daten ist,  min der MinimalWert und #bins die Anzahl klassen.
     */
    public double getBinSize() {
        return 1.0;
    }

    /**
     * Gibt für eine gegebene Klasse (binNumber) die Anzahl Datenelemente zurück
     * die in diese Klasse fallen. Wir beginnen bei 0 zu zählen. Das erste Bin hat
     * also den index 0.
     */
    public int getNumberOfEntriesInBin(int binNumber) {

        int[] numEntries = {1, 4, 1, 5, 0, 0, 2};
        return numEntries[binNumber];
    }


    /**
     * Gibt den kleinsten Wert in den Daten zurück
     */
    public double getMinValue() {
        return -1.0;
    }

    /**
     * Gibt den grössten Wert in den Daten zurück
     */
    public double getMaxValue() {
        return 7;
    }

}
