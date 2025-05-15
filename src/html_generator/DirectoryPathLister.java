package html_generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryPathLister {
    public static void filePathNameLister() {
        String folderPath = "D:\\project_images";
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            List<String> filePaths = new ArrayList<>();
            List<String> fileNames = new ArrayList<>();
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        fileNames.add(file.getName());
                        filePaths.add(file.getAbsolutePath());
                    }
                }

                for (String fileName : fileNames) {
                    System.out.println(fileName);
                }

                for (String filePath : filePaths) {
                    System.out.println(filePath);
                }

            } else  {
                System.out.println("A mappa üres");
            }
        } else {
            System.out.println("A megadott elérési út nem egy mappa, vagy nem létezik");
        }
    }
}
