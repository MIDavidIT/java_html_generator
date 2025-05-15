package html_generator;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Hiba! Adj meg egy elérési utat!");
            System.exit(1);
        }
        File root = new File(args[0]);
        if (!root.isDirectory()) {
            System.out.println("Hiba! Adj meg egy elérési utat!");
            System.exit(1);
        }

        IndexHtmlGenerator.htmlGenerator(args[0]);
        ImageHtmlGenerator.imageHtmlGenerator(args[0]);
    }
}