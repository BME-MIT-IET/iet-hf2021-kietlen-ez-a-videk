<h1>Unit tesztek</h1>

A projekthez készítettünk unit teszteket, amelyek  /src/test mappában találhatóak. A tesztekben a könyvtár belső működését teszteltük különböző konverziókon kersztül junit használatával. 

<h2>A következő eseteket tesztelik a junit-ot használó unit tesztek:</h2>

(A felsorolásban található címek a unit tesztek kódban is megtalálható leírásaira utalnak.)<br>
<br>
    - One letter string to char conversion should work: A CSV2RDF class toChar metódusának tesztje valid bemenettel. <br>
    - Multiple letter to char conversion should fail: A CSV2RDF class toChar metódusának tesztje invalid bemenettel. <br>
    - Empty string to char conversion should fail: A CSV2RDF class toChar metódusának tesztje üres bemenettel.  <br>
    - Test FAIL_ON_UNKNOWN_DATATYPES default configuration should be false: A converter class helyes kezdeti inicializálásának ellenőrzésére szolgáló egyik teszt. <br>
    - Test FAIL_ON_UNKNOWN_LANGUAGES default configuration should be false: A converter class helyes kezdeti inicializálásának ellenőrzésére szolgáló egyik teszt. <br>
    - Running with the example files should succeed: A konverzió futtatása helyes bemeneti fileokat használva.<br>
    - Checking output file after run should succeed: Sikeres futás után a kimenetet ellenőrző teszt.<br>
    - Running with non-existent files should fail: Nem létező fájl bemenettel futtatott konverzió ellenőrzése.<br>

<br>
<h2>Tesztek szeparálása</h2>
Mindegyik teszt futása után elvégezzük a keletkezett ideiglenes input és output fileok takarítását, ami biztosítja, hogy a tesztek ne legyenek egymásra hatással és a local repositoryt se szemeteljék tele.<br>


<br>
<h2>Példa bemenetek</h2>
A repositoryban található example mappában vannak a teszt fájlok, amiket a projekt eredetileg is tartalmazott. Ezek szolgálnak a tesztek többségében helyes bemenetként. Ezeken a fájlokon változtatásokat nem végzünk és nem is töröljük őket.

