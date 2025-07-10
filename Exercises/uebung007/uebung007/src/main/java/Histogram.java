class Histogram {

    // Felder um die Daten sowie die Anzahl Bins zu speichern
    double[] data = null;
    int numberOfBins;

    /**
     * Erzeugt ein Histogram Objekt für die übergebenen Gleitkommazahlen (daten),
     * mit den angegebenen anzahl Klassen (bins).
     * Die Daten sollen in einem Feld data und die anzahl Klassen in einem Feld
     * numberOfBins gespeichert.
     */
    Histogram(double[] data, int numberOfBins) {
        this.data = data;
        this.numberOfBins = numberOfBins;
    }

    /**
     * Gibt die Anzahl Klassen (bins) zurück
     */
    int getNumberOfBins() {
        return this.numberOfBins;
    }

    /*
     * gibt die im Histogram gespeicherten Daten zurück
     */
    double[] getData() {
        return this.data;
    }

    /**
     * Gibt den kleinsten Wert in den Daten zurück
     */
    public double getMinValue() {
        double min = this.data[0];
        for (int i = 0; i < this.data.length; i++) {
            if (min > this.data[i]) {
                min = this.data[i];
            }
        }
        return min;
    }

    /**
     * Gibt den grössten Wert in den Daten zurück
     */
    public double getMaxValue() {
        double max = this.data[0];
        for (int i = 0; i < this.data.length; i++) {
            if (max < this.data[i]) {
                max = this.data[i];
            }
        }
        return max;
    }

    /**
     * Gibt die Grösse einer Klasse (also das Interval zurück). Die Intervallgrösse
     * berechnet sich als (max - min) / #bins, wobei max der Maximalwert in den
     * Daten ist,  min der MinimalWert und #bins die Anzahl klassen.
     */
    public double getBinSize() {
        double intervalSize = (this.getMaxValue() - this.getMinValue()) / numberOfBins;
        return intervalSize;
    }

    /**
     * Gibt für eine gegebene Klasse (bestimmt durch binNumber) die Anzahl
     * Datenelemente zurück die in diese Klasse fallen. Wir beginnen bei 0 zu zählen.
     * Das erste Bin hat also den index 0. Der grösste Wert fällt in den letzten Bin
     *
     * Beispiel:
     * Angenommen wir hätten die Daten [4.1, 1.5, 5.0, 1.0, 3.0, 3.5, 4.0, 3.1]
     * und 4 bins. Dann wäre
     * getNumberOfEntriesInBin(0) = 2  (nämlich 1.0 und 1.5)
     * getNumberOfEntriesInBin(1) = 0
     * getNumberOfEntriesInBin(2) = 3  (nämlich 3.0, 3.1, 3.5)
     * getNumberOfEntriesInBin(3) = 3  (nämlich 4.0, 4.1, 5.0)
     *
     * Beachten Sie, dass das letzte Bin speziell behandelt werden muss, da es
     * zusätzlich auch das maximale Element beinhaltet
     */
    public int getNumberOfEntriesInBin(int binNumber) {

        double start = this.getMinValue() + binNumber * this.getBinSize();
        double end = this.getMinValue() + binNumber * this.getBinSize() + this.getBinSize();
        int counter = 0;
        
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] >= start && this.data[i] < end) {
                counter++;
            }
        }

        if (binNumber + 1 == numberOfBins) {
            counter++;
        }

        return counter;

    }


    public static void main(String[] args) {
        double[] data = new double[]{4.1, 1.5, 5.0, 1.0, 3.0, 3.5, 4.0, 3.1};
        int numberOfBins = 4;
        Histogram histogram = new Histogram(data, numberOfBins);
        System.out.println(histogram.getNumberOfEntriesInBin(3));

    }

}
