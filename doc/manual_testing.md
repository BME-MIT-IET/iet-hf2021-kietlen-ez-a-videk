<h1>Manuális Tesztek</h1>
<h2>Tervezés:</h2>
A Manuális tesztek elvégzése során a Black box elv szerint fogunk haladni. A folyamat első lépése a könyvtár megvizsgálása és a tesztelni kívánt részek kiválasztása. Össze kell gyűjteni minden olyan elvárást, amit a szoftverrel szemben felállítottunk és ezek alapján írjuk össze a teszt eseteket. Ha a teszteket megvalósítottuk és lefuttattuk, az esetleges hibákról értesítjük a fejlesztőket, és a hibák javítása után újra lefuttatjuk a teszteket.

A csv2rdf feladata egy RDF output generálása CSV/TSV fájlokból. A felhasználó támogatására egy példa fájl készült ami megmutatja hogyan fog kinézni a kész RDF output egy sora. 

<h3>A példák és dokumentáció alapján a következő elvárásokat állítottuk fel a szoftverrel szemben:</h3>

1.	Elfogadja a helyes bemeneti fájlokat
2.	Nem fogad el nem megfelelő formátumú bemenetet
3. Nem fogad el nem megfelelő formátumú sablont
4.	A kimenete egy RDF output 
5.	Az output megfelel a megadott mintának

<h3>A fentiek biztosítására az alábbi teszt esetekre lesz szükség:</h3>

1.	Könyvtár használata alkalmas fájlokon azzal az elvárással, hogy lefut
2.	Könyvtár használata alkalmatlan fájlokon azzal az elvárással, hogy hibát jelez
3.	Könyvtár használata nem kapcsolódó sablon és bemenet fájlon azzal az elvárással, hogy hibát jelez
4.	Könyvtár kimenetének formai vizsgálata helyes bemeneteken fájlformátumra és tartalomra

<h2>Megvalósítás</h2>
A kész tesztek kódja a tests/ManualTests.java fileban található és a fenti tesztesetekhez az alábbi teszteket tartalmazza:

<h4>Könyvtár használata alkalmas fájlokon</h4>
 
 * SuitableInput

<h4>Könyvtár alkalmatlan fájlokon</h4>
 
 * IncorrectInputName
 * IncorrectInput
 * IncorrectTemplateContent
 
<h4>Könyvtár nem kapcsolódó sablonon és bemeneti fájlon</h4>

 * UnmatchingTemplateAndCsv

<h4>Könyvtár kimenetének formai vizsgálata</h4>

 * CorrectOutput

<h2>Tesztek Dokumentációja</h2>
Ebben a fejezetben a megírt teszteket és a kapott eredményeket fejtjük ki.

<h4>Könyvtár használata alkalmas fájlokon</h4>
 
 Ezt a tesztesetet a *SuitableInput* teszttel vizsgáltuk, ami egy helyes inputot ad be a rendszernek a megadott minta szerint az argumentumok listájába. A kód sikeresen lefut, és látjuk, hogy megkapjuk a megfelelő kimenetet.

<h4>Könyvtár használata alkalmatlan fájlokon</h4>
 
 Ezt a tesztesetet három teszt is támogatja:
 
 Az első az *IncorrectInputName*, ez a teszt szándékosan rossz nevet (nem létező filet) ad meg ellenőrizve, hogy a program észreveszi-e a problémát. Ennél a tesztnél futtatásnál egy exceptiont kapunk, azaz nem marad észrevétlen a hiba, sikeres a tesztünk.
 
 A második az *IncorrectInput*, ami szándékosan rossz file-t ad meg ellenőrizve, hogy a program észreveszi-e a problémát. Ennél a tesztnél futtatásnál egy exceptiont kapunk, azaz nem marad észrevétlen a hiba, sikeres a tesztünk.

 A harmadik az *IncorrectTemplateContent*, ami szándékosan tartalmilag hibás sablon fájlt ad meg ellenőrizve, hogy a program észreveszi-e a problémát. Ennél a tesztnél futtatásnál egy exceptiont kapunk, azaz nem marad észrevétlen a hiba, sikeres a tesztünk.
 
<h4>Könyvtár nem kapcsolódó sablonon és bemeneti fájlon</h4>

 Ezt a tesztesetet a *UnmatchingTemplateAndCsv* tesztel vizsgáltuk, ami két helyes tartalmú, de különböző struktúrájú modelt leíró fájlt ad meg ellenőrizve, hogy a program észreveszi-e a problémát. Ennél a tesztnél futtatásnál egy exceptiont kapunk, azaz nem marad észrevétlen a hiba, sikeres a tesztünk.

<h4>Könyvtár kimenetének formai vizsgálata</h4>

Ebben a tesztesetben azt ellenőrizzük, hogy helyes bemenet esetén a kimenet létrejön, és formailag megfelel a mintának. Ezt a *CorrectOutput* teszt vizsgája, és akkor tér vissza sikeresen ha a file létrejön. Esetünkben létrejön a file, és ha formailag ellenőrizzük, akkor meg is felel a mintának, így a sikeres a tesztünk.

<h3>A Tesztek eredményei táblázatosan:</h3>

Teszteset neve | Teszteset eredménye
------------ | -------------
Könyvtár használata alkalmas fájlokon | Sikeres
Könyvtár használata alkalmatlan fájlokon | Sikeres
Könyvtár használata nem kapcsolódó sablon és bemenet fájlon | Sikeres
Könyvtár kimenetének formai vizsgálata | Sikeres
