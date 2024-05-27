class Parkplatz {
    private Fahrzeug fahrzeug;

    public boolean istFrei() {
        return fahrzeug == null;
    }

    public void parken(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }

    public void verlassen() {
        this.fahrzeug = null;
    }

    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }
}