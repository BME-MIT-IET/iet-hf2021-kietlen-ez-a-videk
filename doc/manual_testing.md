<h1>Manuális Tesztek</h1>
<h2>Tervezés:</h2>
A Manuális tesztek elvégzése során a Black box elv szerint fogunk haladni. A folyamat első lépése a könyvtár megvizsgálása és a tesztelni kívánt részek kiválasztása. Össze kell gyűjteni minden olyan elvárást, amit a szoftverrel szemben felállítottunk és ezek alapján írjuk össze a teszt eseteket. Ha a teszteket megvalósítottuk és lefuttattuk, az esetleges hibákról értesítjük a fejlesztőket, és a hibák javítása után újra lefuttatjuk a teszteket.

A csv2rdf feladata egy RDF output generálása CSV/TSV fájlokból. A felhasználó támogatására egy példa fájl készült ami megmutatja hogyan fog kinézni a kész RDF output egy sora. A példák és dokumentáció alapján a következő elvárásokat állítottuk fel a szoftverrel szemben:

1.	Elfogadja a bemeneti fájlokat
2.	Nem fogad el nem megfelelő formátumú bemenetet
3.	A kimenete egy RDF output 
4.	Az output megfelel a megadott mintának

A fentiek biztosítására az alábbi teszt esetekre lesz szükség:

1.	Könyvtár használata alkalmas fájlokon azzal az elvárással, hogy lefut
2.	Könyvtár használata alkalmatlan fájlokon azzal az elvárással, hogy hibát jelez
3.	Könyvtár kimenetének formai vizsgálata különböző helyes bemeneteken fájlformátumra és tartalomra

A fent felsorolt teszt esetekre a JUnit keretrendszert fogjuk használni, azokat a dolgokoat pedig, amiket célszerűbb személyesen ellenőrizni, azokat mi fogjuk megnézni.


