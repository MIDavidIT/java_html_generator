Java kód, ami egy project_images nevű könyvtárban az összes képhez generál egy saját .hmtl fájlt, valamint minden könyvtárban egy index.html-t.
A kód rekurzív, szóval a project_images nevű könytárban található alkönyvtárakba is legenerálja a .html fájlokat

A project_images mappában még megtalálható egy html_deleter.bat fájl, ami kitörli a mappábanm megtalálható összes .html fájlt.

Futtatási útmutató: (Abban a mappában futtasd ezeket a scripteket, amiben megtalálhatóak ezek a fájlok)
./main.java <project_images mappa elérési útja>
./html_deleter.bat delete
