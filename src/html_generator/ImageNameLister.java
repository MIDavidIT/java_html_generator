package html_generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImageHtmlGenerator {
    public static List<String> imageNameLister() {
        String folderPath = "D:\\project_images";
        File image = new File(folderPath);
        List<String> imageNames = new ArrayList<>();

        if (image.exists() && image.isDirectory()) {
            File[] names = image.listFiles();

            if (names != null) {
                for (File name : names) {
                    if (!(name.isDirectory()) && !(name.getName().equals("index.html"))) {
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
