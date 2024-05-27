import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus();
        hauptmenue(parkhaus);
    }

    public static void hauptmenue(Parkhaus parkhaus) {
        Scanner scan = new Scanner(System.in);
        boolean check = true;


        // Hauptmenü mit Auswahlmöglichkeiten

        while (check) {
            System.out.println("----------------------------------");
            System.out.println("Hauptmenü - Parkhaus \tAlina Marschke");
            System.out.println("----------------------------------");
            System.out.println("Bitte wählen Sie aus:");
            System.out.println("1- Etagen hinzufügen \n2- Einfahren\n3- Ausfahren\n4- Parkplatz des Autos abfragen\n5- Leere Parkplätze abfragen\n6- Etage löschen\n7- Beenden");
            System.out.println("----------------------------------");

            if (scan.hasNextInt()) {
                int eingabe = scan.nextInt();

                switch (eingabe) {
                    case 1:
                        System.out.println("Wie viele Etagen möchten Sie hinzufügen?");
                        if (scan.hasNextInt()) {
                            int anzahlEtagen = scan.nextInt();
                            parkhaus.etagenHinzufuegen(anzahlEtagen);
                        } else {
                            System.err.println("Falsche Eingabe. Bitte geben Sie eine Zahl ein.");
                            scan.nextLine();
                        }
                        break;
                    case 2:
                        System.out.println("Bitte geben Sie das Autokennzeichen ein:");
                        String kennzeichenEinfahren = scan.nextLine();
                        System.out.println("Bitte wählen Sie Ihr Fahrzeug aus: ");
                        System.out.println("1 - Auto");
                        System.out.println("2 - Motorrad");
                            int auswahlFahrzeug = scan.nextInt();
                            if (auswahlFahrzeug == 1) {
                                parkhaus.einfahren(new Auto(kennzeichenEinfahren));
                            } else if (auswahlFahrzeug == 2) {
                                parkhaus.einfahren(new Motorrad(kennzeichenEinfahren));
                            } else {
                                System.out.println("Ungültiger Fahrzeugtyp.");
                            }
                        break;
                    case 3:
                        System.out.println("Bitte geben Sie das Autokennzeichen ein:");
                        String ausfahrtFahrzeug = scan.nextLine();
                        parkhaus.ausfahren(ausfahrtFahrzeug);
                        break;
                    case 4:
                        System.out.println("Bitte geben Sie das Autokennzeichen ein:");
                        String kennzeichenAbfragen = scan.nextLine();
                        parkhaus.parkplatzAbfragen(kennzeichenAbfragen);
                        break;
                    case 5:
                        parkhaus.leereParkplaetzeAbfragen();
                        break;
                    case 6:
                        System.out.println("Welche Etage wollen Sie löschen?");
                        if (scan.hasNextInt()) {
                            int etageLoeschen = scan.nextInt();
                            parkhaus.etageLoeschen(etageLoeschen);
                        } else {
                            System.err.println("Falsche Eingabe. Bitte geben Sie eine Zahl ein.");
                            scan.nextLine();
                        }
                        break;
                    case 7:
                        check = false;
                        break;
                    default:
                        System.err.println("Falsche Eingabe.");
                }
            } else {
                System.err.println("Falsche Eingabe. Bitte geben Sie eine Zahl ein.");
                scan.nextLine();
            }
        }
        scan.close();
    }
}

