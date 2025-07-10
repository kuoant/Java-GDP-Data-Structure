import java.nio.file.Path;
import java.nio.file.Paths;

public class Example001_Paths {
    public static void main(String[] args) {
        Path currentLocation = Paths.get("");
        System.out.println("Ausführungsverzeichnis: \"" + currentLocation + "\"");
        System.out.println("Absoluter Pfad: " + currentLocation.toAbsolutePath());
        // System.out.println("\n\n=====================================================");

        // // Hier wird der Benutzer angezeigt:
        // Path home = Paths.get(System.getProperty("user.home"));
        // System.out.println("Benutzerverzeichnis: " + home);

        // Path output = currentLocation.resolve("output"); // resolve hängt etwas an, eine neue Datei, die noch nicht existiert
        // System.out.println("Ausgabeverzeichnis: " + output.toAbsolutePath());

        // System.out.println("\n\n=====================================================");

        // System.out.println("Project name: " + currentLocation.toAbsolutePath().getFileName()); // letztes Element abfragen, muss nicht unbedingt ein Ordner sein, kann auch ein Word-Dokument sein
        // System.out.println("Project location: " + currentLocation.toAbsolutePath().getParent()); // darüberliegendes Verzichnis

        // // TODO mini exercise
        // // - create a path that represents the data directory
        // // - create a path that points to a yet non-existing file in the data directory
        // // - print the directory where your non-existing file is located (use only the path pointing to the file)
        
        // Path data = currentLocation.resolve("data");
        // Path someFile = data.resolve("some.txt"); // wird einfach als neues Element angehängt. Es erstellt nur Adressen, es wird kein neuer Ordner erstellt.
        // System.out.println(someFile.getParent());


    }
}