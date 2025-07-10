class Complex {

    double real;
    double imag;

    /**
     * Erstellt eine neue Komplexe Zahl mit gegebenem
     * Real- und imaginärteil.
     */
    Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * Addiert die Komplexe Zahl other mit der durch dieses
     * Objekt repräsentierte komplexen Zahl und gibt das Ergebnis
     * als neue Komplexe Zahl zahl zurück.
     */
    public Complex add(Complex other) {

        double x = this.real + other.real;
        double y = this.imag + other.imag;

        Complex result = new Complex(x, y);
        return result;
    }

    /* Addiert die Komplexe Zahl other mit der durch dieses
    * Objekt repräsentierte komplexen Zahl. Durch diese
    * Operation soll das akutelle Objekt der addition beider
    * Zahlen entsprechen.
    */
    public void addInplace(Complex other) {

        double x = this.real + other.real;
        double y = this.imag + other.imag;

        this.real = x;
        this.imag = y;
    }

    /**
     * Multipliziert die Komplexe Zahl other mit der durch dieses
     * Objekt repräsentierte komplexen Zahl und gibt das Ergebnis
     * als neue Komplexe Zahl zahl zurück.
     */
    Complex multiply(Complex other) {

        double x = this.real * other.real - this.imag * other.imag;
        double y = this.real * other.imag + this.imag * other.real;

        Complex result = new Complex(x, y);
        return result;
    }

    /* Multipliziert die Komplexe Zahl other mit der durch dieses
    * Objekt repräsentierte komplexen Zahl. Durch diese
    * Operation soll das akutelle Objekt der Multiplikation beider
    * Zahlen entsprechen.
    */
    void multiplyInplace(Complex other) {

        double x = this.real * other.real - this.imag * other.imag;
        double y = this.real * other.imag + this.imag * other.real;

        this.real = x;
        this.imag = y;
    }


    /**
     * Gibt den Absolutwert der komplexen Zahl zurück
     */
    public double abs() {
        return Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imag, 2));
    }

}
