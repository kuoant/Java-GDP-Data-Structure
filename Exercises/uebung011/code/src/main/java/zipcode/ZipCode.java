package zipcode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ZipCode {

    //private static final Exception NoSuchElementException = null;
    Map<Integer, String> zipCodeMap = new HashMap<>();
    Map<String, LinkedList<String>> nameWithCantonsMap = new HashMap<>();

    /**
     * Kreiert ein neues Zip-Code Objekt mit den in der Datei file übergebenen
     * Daten.
     */
    ZipCode(File file) throws FileNotFoundException {
        // Ihre Implementation

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(";");
                zipCodeMap.put(Integer.parseInt(values[2]), values[1]);
            }
        
        } catch (IOException e) {

            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
        
            while((line = br.readLine()) != null) {

                String[] s = line.split(";");
                LinkedList<String> l = nameWithCantonsMap.get(s[1]);
                if (l == null) {
                    l = new LinkedList<String>();
                    nameWithCantonsMap.put(s[1], l);
                }
                l.add(s[0]);
            }
        
        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * Gibt den Namen des Ortes zu der übergebenen Postleitzahl zurück. Falls die
     * Postleitzahl nicht existiert, wird eine NoSuchElementException geworfen
     */
    String getNameForZipCode(int plz) throws NoSuchElementException {

        if (zipCodeMap.containsKey(plz)) {
            return zipCodeMap.get(plz);
        } else {
            NoSuchElementException element = new NoSuchElementException();
            throw element;
        }
    }

    /**
     * Gibt eine Liste mit allen Kantonen zurück, in denen der übergebene Ortsname
     * vorkommt. Falls der Ort nicht existiert wird eine leere Liste zurückgegeben.
     */
    LinkedList<String> getAllCantonsForName(String name) {

        LinkedList<String> result = new LinkedList<>();

        if (nameWithCantonsMap.containsKey(name)) {
            result = nameWithCantonsMap.get(name); 
        }

        return result;
    }

    public static void main(String[] args) {
        
    }
}

