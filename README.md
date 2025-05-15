Java kód, ami egy project_images nevű könyvtárban az összes képhez generál egy saját .hmtl fájlt, valamint minden könyvtárban egy index.html-t.
A kód rekurzív, szóval a project_images nevű könytárban található alkönyvtárakba is legenerálja a .html fájlokat

A project_images mappában még megtalálható egy html_deleter.bat fájl, ami kitörli a mappában megtalálható összes .html fájlt.

Windows futtatási útmutató: (navigáljunk abba a mappába, ahol megtalálható az src)
Fordítás: javac -d bin src/html_generator/*.java
Futtatás: java -cp bin html_generator.Main "project_images elérési útja"

.html fájlok törlése: (navigáljunk be a project_images mappába)
./html_deleter.bat delete
