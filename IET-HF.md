<h1>A felhasznált CSV2RDF projekt összefoglalása</h1>


A projekt, amivel dolgoztunk, egy könyvtár típusú   ahogy azt a neve is súgja CSV és TSV fileokból történő konvertálást végez RDF fájl kimenetet előállítva. A konvertálás egy template fájl alapján történik, ami a kimeneti fájl kinézetét, formázását adja. 

A projekt kódja nem túl komplex, könnyen megérthetőek az egyes részek feladati, ezért a tesztelés sem jelentet gondot. Ellenben viszont nincsen túldokumentálva, csak pár példafájl található benne, amiből a felhasználó kiindulhat. A tesztelés ezért nagy részt a forráskód tanulmányozás után tudott megtörténni.

A projekt ant build eszközt használ, amivel egyikőnknek sem volt még gyakorlatban dolga. A kezdeti build.xml konfigurációs fájlt módosítottuk és kiegészítettük test és sonar targetekkel is, amik a unit teszteket és a statikus analízist futtatják.