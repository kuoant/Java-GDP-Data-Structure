import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example002_Files {
    public static void main(String[] args) {

        Path currentLocation = Paths.get("").toAbsolutePath(); //Verzeichnis wo die Dateien liegen

        System.out.println(currentLocation);

        boolean exists = Files.exists(currentLocation); // ja existiert oder nein existiert nicht
        System.out.println("Current location exists: " + exists);

        Path fantasyLocation = Paths.get("fantasy"); // Fantasie-Pfad, der noch nicht existiert
        System.out.println("Fantasy location exists: " + Files.exists(fantasyLocation));

        // exists sagt uns, ob wir am fantasieren sind oder nicht

        Path sourceFile = currentLocation.resolve("Example002_Files.java"); // fügt den Namen unseres Files hinzu
        System.out.println(Files.isRegularFile(sourceFile)); // ist es eine Datei?
        System.out.println(Files.isDirectory(sourceFile)); // ist es ein Pfad?


        try {

            for (Path p : Files.newDirectoryStream(currentLocation)) { // Fehler, wenn wir hier ein File angeben möchten
                System.out.println(p);
            }


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        // TODO mini exercise
        // - change the above loop in order to print all files in the project directory.
        
        // Dieser Code erstellt nun einen neuen Ordner mit dem Namen log:

        try {
            Path logDir = Paths.get("").resolve("log");
            if( !Files.exists(logDir)) {
                Files.createDirectories(logDir); 
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }
}