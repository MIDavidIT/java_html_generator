package html_generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryNameLister {
    public static List<String> fileNameLister(String directoryPath) {
        // Csinálok egy új File-t az átadott elérési útvonalból
        File folder = new File(directoryPath);

        // Csinálok egy String listát, amibe el akarom tárolni a könyvtárok neveit
        List<String> fileNames = new ArrayList<>();

        // Megnézi, hogy az adott File létezik-e és, hogy mappa-e
        if (folder.exists() && folder.isDirectory()) {

            // Ha igaz, akkor egy File tömbbe elmenti a főkönytárban található összes mappa nevét
            File[] files = folder.listFiles();

            // Megnézi, hogy a tömb üres-e
            if (files != null) {

                // Ha nem, akkor végigmegy a mappák nevein
                for (File file : files) {

                    // Megnézi, hogy a fájlok könyvtárok-e, ha igen, akkor a fileNames listába beleteszi nevüket.
                    // Miután végzett visszaadja a listát
                    if (file.isDirectory()) {
                        fileNames.add(file.getName());
                    }
                }
            } else  {
                System.out.println("A mappa üres");
            }
        } else {
            System.out.println("A megadott elérési út nem egy mappa, vagy nem létezik");
        }
        return fileNames;
    }
}