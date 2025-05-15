package html_generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageHtmlGenerator {
    public static void imageHtmlGenerator(String args) {
        // Listába kiíratja a fő- és annak a gyökérkönyvtárainak a nevét
        File path = new File("D:/project_images");
        List<String> directoryPaths = DirectoryPathLister.filePathLister(path);
        directoryPaths.add(args);

        // Végigmegy az összes könyvtáron, és az abban található összes képnek csinál egy azonos nevű .html kiterjesztésű fájlt
        for (String directoryPath : directoryPaths) {

            // Listába kiíratja az adott könyvtárban található összes kép nevét és a kiterjesztésüket
            List<String> imageNames = ImageNameLister.imageNameLister(directoryPath);
            List<String> convertedImages = imageConverter(imageNames);

            // Végigmegy az összes képen
            for (String imageNameIn : imageNames) {

                // Az addot könyvtárban található összes képnek átírja a kiterjesztését .html-re, majd legenerálja azokat
                int dotIndex = imageNameIn.lastIndexOf(".");
                String imageNameOut = imageNameIn.substring(0, dotIndex) + ".html";
                String filePath = directoryPath + "/";

                // Legenerálom a egy File-t az elérési útból és a névből
                File htmlFile = new File(filePath + imageNameOut);

                // Kiírja, hogy melyik könyvtárba generálta le a képek .html fájljait
                System.out.println("Az " + imageNameOut + " fájl létrehozva a következő elérési úton: " + htmlFile.getAbsolutePath());

                // Mik kerülnek az egyes képek .html fájljaiba
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile))) {
                    writer.write("<!DOCTYPE html>");
                    writer.write("<html>");
                    writer.write("<head>");

                    // Oldal címe
                    writer.write("<title>Projektfeladat - Java</title>");

                    writer.write("</head>");
                    writer.write("<body style=\"background-color:#D3D3D3;\">");

                    // Kezdőlap gomb, ami a gyökérkönyvtárban található index.html-re visz
                    writer.write("<h1><a href=\"/project_images/index.html\">Kezdőlap</a></h1>");

                    writer.write("<hr>"); // aláhúzás

                    // Felfelé mutató nyíl, amire kattintva átírányít az adott könyvtár index.html fájljára
                    writer.write("<u><a href=\"index.html\">^^</a></u>");

                    writer.write("<br></br>"); // Sortörés

                    // A metódusoknak átadom az adott könyvtárban található képek listáját, amit már át van konvertálva, illetve az adott kép nevét kiterjesztéssel együtt (.html)
                    // Elmentem egy String változóba az adott kép balra, illetve a jobbra található szomszédját (.html kiterjesztéssel)
                    // Ha a képnek nincs baloldali vagy jobboldali szomszédja, akkor magát az adott képet kapom vissza (ugyan úgy .html kiterjesztéssel)
                    String left = turnLeft(convertedImages, imageNameOut);
                    String right = turnRight(convertedImages, imageNameOut);

                    // Balra mutató nyíl, amire kattintva átírányít az adott kép baloldali szomszédjának .html fájljára
                    writer.write("<a href=\"" + left + "\"><b><u><<</u></b></a>&emsp;");

                    // Kiíratom az adott kép nevét és kiterjesztését (nem .html)
                    writer.write("<b><font size=\"5\">" + imageNameIn + "</font></h2></b>");

                    // Jobbra mutató nyíl, amire kattintva átírányít az adott kép jobboldali szomszédjának .html fájljára
                    writer.write("&emsp;<a href=\"" + right + "\"><b><u>>></b></u></a>");

                    writer.write("<br></br>"); // Sortörés

                    // Megjeleníti a képet, amit méretre szabtam
                    writer.write("<a href=\"" + right + "\"><img src=\"" + imageNameIn + "\"style=\"width:600px;height:400px;\"></a>");

                    writer.write("</body>");
                    writer.write("</html>");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Visszaadja az átadott kép baloldali szomszédjának .html fájlját
    public static String turnLeft(List<String> names, String name) {
        String left = "";

        // Végimegy a képek .html kiterjsztésű fájljait tartalmazó lista elemein
        for (int i = 0; i < names.size() - 1; i++) {

            // Ha az átadott kép megegyezik az adott listában szereplő i-edik indexű értékkel, akkor belementi a left nevű változóba,
            // utána kilép az if ciklusból, majd visszaadja azt
            if (name.equals(names.get(0))) {
                left = name;
                break;
            }

            // Ellenkező esetben feltételezhető, hogy az átadott képnek nincs baloldali szomszédja, így önmagát adja vissza
            else {
                left = names.get(names.lastIndexOf(name) - 1);
            }
        }
        return left;
    }

    // Visszaadja az átadott kép jobboldali szomszédjának .html fájlját
    public static String turnRight(List<String> names, String name) {
        String right = "";

        // Végimegy a képek .html kiterjsztésű fájljait tartalmazó lista elemein
        for (int i = 0; i < names.size() - 1; i++) {

            // Ha az átadott kép megegyezik az adott listában szereplő i-edik indexű értékkel, akkor belementi a right nevű változóba,
            // utána kilép az if ciklusból, majd visszaadja azt
            if (name.equals(names.get(names.size() - 1))) {
                right = name;
                break;
            }

            // Ellenkező esetben feltételezhető, hogy az átadott képnek nincs jobboldali szomszédja, így önmagát adja vissza
            else {
                right = names.get(names.lastIndexOf(name) + 1);
            }
        }
        return right;
    }

    // Átírja az összes kép kiterjesztését .html-re
    public static List<String> imageConverter(List<String> names) {

        // Létrehozok egy új listát, amiben tárolni akarom a képek.html-eket
        List<String> namesLeftHtml = new ArrayList<>();

        // Végigmegy a lista elemein és a kiterjesztésüket átírja .html-re.
        // Ha végez, akkor visszaadja a listát
        for (String imageNameIn : names) {
            int dotIndex = imageNameIn.lastIndexOf(".");
            namesLeftHtml.add(imageNameIn.substring(0, dotIndex) + ".html");
        }
        return namesLeftHtml;
    }
}