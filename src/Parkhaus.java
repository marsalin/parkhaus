import java.util.ArrayList;

class Parkhaus {
    private ArrayList<Parketage> etagen;

    public Parkhaus() {
        etagen = new ArrayList<>();
    }

    // fügt dem Parkhaus eine bestimmte Anzahl von Etagen hinzu
    public void etagenHinzufuegen(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            etagen.add(new Parketage(10));
        }
        System.out.println(anzahl + " Etagen wurden hinzugefügt.");
    }

    // parkt ein Fahrzeug
    public void einfahren(Fahrzeug fahrzeug) {
        for (Parketage etage : etagen) {
            if (etage.hatFreienParkplatz()) {
                etage.parken(fahrzeug);
                System.out.println("Das Fahrzeug mit dem Kennzeichen " + fahrzeug.getKennzeichen() + " ist eingefahren.");
                return;
            }
        }
        System.out.println("Kein freier Parkplatz verfügbar.");
    }

    // entfernt ein Fahrzeug aus dem Parkhaus
    public void ausfahren(String kennzeichen) {
        for (Parketage etage : etagen) {
            etage.verlassen(kennzeichen);
            System.out.println("Das Fahrzeug mit dem Kennzeichen " + kennzeichen + " ist ausgefahren.");
            return;
        }
        System.out.println("Fahrzeug mit dem Kennzeichen " + kennzeichen + " wurde nicht gefunden.");
    }

    // gibt Parkplatz eines Fahrzeuges aus
    public void parkplatzAbfragen(String kennzeichen) {
        for (int i = 0; i < etagen.size(); i++) {
            int parkplatzIndex = etagen.get(i).findeFahrzeug(kennzeichen);
            if (parkplatzIndex != -1) {
                System.out.println("Das Fahrzeug mit dem Kennzeichen " + kennzeichen + " befindet sich auf Etage " + (i + 1) + ", Parkplatz " + (parkplatzIndex + 1) + ".");
                return;
            }
        }
        System.out.println("Fahrzeug mit dem Kennzeichen " + kennzeichen + " wurde nicht gefunden.");
    }

    // gibt Anzahl der leeren Parkplätze aus
    public void leereParkplaetzeAbfragen() {
        for (int i = 0; i < etagen.size(); i++) {
            int freiePlaetze = etagen.get(i).freieParkplaetze();
            System.out.println("Etage " + (i + 1) + " hat " + freiePlaetze + " freie Plätze.");
        }
    }

    // Entfernt eine Etage aus dem Parkhaus
    public void etageLoeschen(int etage) {
        if (etage <= etagen.size() && etage > 0) {
            etagen.remove(etage - 1);
            System.out.println("Etage " + etage + " wurde gelöscht.");
        } else {
            System.out.println("Etage " + etage + " existiert nicht.");
        }
    }
}