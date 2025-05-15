package html_generator;

import java.io.*;
import java.util.List;

public class index {
    public static void main(String[] args) {
        String fileName = "index.html";
        String filePath = "D:\\project_images/";

        File htmlFile = new File(filePath + fileName);

        System.out.println("Az " + fileName + " fájl létrhozva a következő elérési úton: " + htmlFile.getAbsolutePath());


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile))){
            writer.write("<!DOCTYPE html>");
            writer.write("<html>");
            writer.write("<head>");
            writer.write("<title>Projektfeladat - Java</title>");
            writer.write("</head>");

            writer.write("<body>");
            writer.write("<a href=\"file:///D:/project_images/index.html\"><h1>Kezdőlap</h1></a>");
            writer.write("<hr>");
            writer.write("<h1>Könyvtárak:</h1>");

            // Nem ez a végleges
            writer.write("<h2>&#x2022;American</h2>");
            writer.write("<h2>&#x2022;Brazilian</h2>");
            writer.write("<h2>&#x2022;British</h2>");
            writer.write("<h2>&#x2022;Hungarian</h2>");
            writer.write("<h2>&#x2022;Italian</h2>");
            writer.write("<h2>&#x2022;Russian</h2>");
            writer.write("<h2>&#x2022;Sweedish</h2>");


            writer.write("<hr>");
            writer.write("<h1>Képek:</h1>");

            writer.write("</body>");
            writer.write("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
