package html_generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageNameLister {
    public static List<String> imageNameLister(String directoryPath) {

        // Csinálok egy új File-t az átadott elérési útvonalból
        File image = new File(directoryPath);

        // Csinálok egy String listát, amibe el akarom tárolni a képek neveit és kiterjesztésüket
        List<String> imageNames = new ArrayList<>();

        // Megnézi, hogy az adott File létezik-e és, hogy mappa-e
        if (image.exists() && image.isDirectory()) {

            // Ha igaz, akkor egy File tömbbe elmenti a főkönytárban található összes mappa nevét
            File[] names = image.listFiles();

            // Megnézi, hogy a tömb üres-e
            if (names != null) {

                // Ha nem, akkor végigmegy a fájlok nevein
                for (File name : names) {

                    // Ha a fájlok nem könyvtárok && nem az a nevük, hogy html_deleter.bat && nem .html-re végződnek,
                    // akkor az imageNames listába beleteszi a nevüket, majd ha mindennel végez, akkor visszaadja azt a listát
                    if (!(name.isDirectory()) && !(name.getName().equals("html_deleter.bat")) && !(name.getName().endsWith(".html"))) {
                        imageNames.add(name.getName());
                    }
                }
            } else  {
                System.out.println("A mappa üres");
            }
        } else {
            System.out.println("A megadott elérési út nem egy mappa, vagy nem létezik");
        }
        return imageNames;
    }
}