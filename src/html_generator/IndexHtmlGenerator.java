package html_generator;

import java.io.*;
import java.util.List;

public class IndexHtmlGenerator {
    public static void htmlGenerator(String args) {
    // Használd a paraméterként kapott útvonalat a hardkódolt helyett
        File path = new File(args);
        List<String> directoryPaths = DirectoryPathLister.filePathLister(path);

        // Végigmegy az összes könyvtáron, és mindegyikbe legenerál egy index.html fájlt
        for (String directoryPath : directoryPaths) {
            String fileName = "index.html";
            String filePath = directoryPath + "/";

            // Legenerálom a File-t az elérési útból és a névből
            File htmlFile = new File(filePath + fileName);

            // Kiírja, hogy melyik könyvtárba generált le index.html fájlt
            System.out.println("Az " + fileName + " fájl létrehozva a következő elérési úton: " + htmlFile.getAbsolutePath());

            // Mik kerülnek az index.html-be
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile))){
                writer.write("<!DOCTYPE html>");
                writer.write("<html>");
                writer.write("<head>");

                // Oldal címe
                writer.write("<title>Projektfeladat - Java</title>");

                writer.write("</head>");
                writer.write("<body style=\"background-color:#D3D3D3;\">");

                // Kezdőlap gomb, ami a gyökérkönyvtárban található index.html-re visz
                writer.write("<h1><a href=\"/project_images/index.html\">Kezdőlap</a></h1>");

                writer.write("<hr>"); // Aláhúzás

                writer.write("<h1>Könyvtárak:</h1>");

                // Visszagomb, ami visszavisz az adott könyvtár szülőmappájában lévő index.html-re
                File mother = new File(directoryPath);
                if (!(mother.getAbsolutePath().equals("D:\\project_images"))) {
                    writer.write("<p><a href=\"" + mother.getParentFile().getAbsolutePath() + "/index.html\"><<<</a></p>");
                }

                // Könyvtárnevek kiíratása és kattinthatóvá tétele.
                // Rákattintva átírányít az adott könyvtár index.html-jére
                List<String> directoryNames = DirectoryNameLister.fileNameLister(directoryPath);
                for (String directoryName : directoryNames) {
                    writer.write("<p><a href=\"" + directoryName + "/index.html\">" + directoryName + "</a></p>");
                }

                writer.write("<hr>"); // Aláhuzás

                writer.write("<h1>Képek:</h1>");

                // Képnevek kiíratása és kattinhatóvá tétele.
                // Rákattintva átírányít az adott kép .html-jére
                List<String> imageNames = ImageNameLister.imageNameLister(directoryPath);
                for (String imageName : imageNames) {
                    int dotIndex = imageName.lastIndexOf(".");
                    String imageNameOut = imageName.substring(0,dotIndex) + ".html";
                    writer.write("<p><a href=\"" + imageNameOut + "\">"+ imageName + "</a></p>");
                }

                writer.write("</body>");
                writer.write("</html>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}