import java.util.ArrayList;

class Parketage {
    private ArrayList<Parkplatz> parkplaetze;

    // anlegen der Parketagen
    public Parketage(int anzahlParkplaetze) {
        parkplaetze = new ArrayList<>();
        for (int i = 0; i < anzahlParkplaetze; i++) {
            parkplaetze.add(new Parkplatz());
        }
    }

    // Überprüfung, ob freie Parkplätze vorhanden
    public boolean hatFreienParkplatz() {
        for (Parkplatz parkplatz : parkplaetze) {
            if (parkplatz.istFrei()) {
                return true;
            }
        }
        return false;
    }

    // Methode zum Parken
    public void parken(Fahrzeug fahrzeug) {
        for (Parkplatz parkplatz : parkplaetze) {
            if (parkplatz.istFrei()) {
                parkplatz.parken(fahrzeug);
                return;
            }
        }
    }

    // entfernt ein Fahrzeug an Hand des Kennzeichens
    public void verlassen(String kennzeichen) {
        for (Parkplatz parkplatz : parkplaetze) {
            if (!parkplatz.istFrei() && parkplatz.getFahrzeug().getKennzeichen().equals(kennzeichen)) {
                parkplatz.verlassen();
                return;
            }
        }
    }

    // Ausgabe freier Parkplätze
    public int freieParkplaetze() {
        int freie = 0;
        for (Parkplatz parkplatz : parkplaetze) {
            if (parkplatz.istFrei()) {
                freie++;
            }
        }
        return freie;
    }

    // Fahrzeug finden
    public int findeFahrzeug(String kennzeichen) {
        for (int i = 0; i < parkplaetze.size(); i++) {
            Parkplatz parkplatz = parkplaetze.get(i);
            if (!parkplatz.istFrei() && parkplatz.getFahrzeug().getKennzeichen().equals(kennzeichen)) {
                return i;
            }
        }
        return -1;
    }
}