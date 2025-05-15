package html_generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryPathLister {
    public static List<String> filePathLister(File path) {
        File dir = new File(String.valueOf(path));
        List<String> paths = new ArrayList<>();

        // Ellenőrizze, hogy a bemeneti objektum egy könyvtár-e
        if (path.isDirectory()) {
            paths.add(path.getAbsolutePath());

            // Listázza a könyvtárban lévő fájlokat és alkönyvtárakat
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Rekurzív hívás az alkönyvtárakra, és hozzáadja az eredményeket a listához
                    paths.addAll(filePathLister(file));
                }
            }
        }
        return paths;
    }
}