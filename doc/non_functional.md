<h1>Nem-funkcionális jellemzők vizsgálata</h1>

<h2>A szoftver vizsgálata során a következő nem-funkcionális jellemzőket vizsgáljuk:</h2>

* Teljesítmény
*	Skálázhatóság és Stressz teszt
*	Használhatóság
*	Megbízhatóság
*	Karbantarthatóság
*	Biztonság

<h2>Teljesítmény</h2>
Egy program teljesítménye a működésének gyorsaságára utal, esetünkben leírja, hogy mennyi idő telik el a kimenet generálásának befejezéséig.
**Ez esetünkben Xs lett, amit elfogadhatónak találtunk.**

<h2>Skálázhatóság és Stressz teszt</h2>
A skálázhatóság mérése azt a pontot segíti megtalálni, hogy mekkora az a legnagyobb terhelés, amin a szoftver még elfogadhatóan működni fog, A Stressz teszt a normál működésnél nagyobb terhelés alatt vizsgálja a szoftver működését. Esetünkben ezek nem egy fontos paraméterek, mert egy bemenetet alakítunk egy kimenetté és amennyiben több kimenetet szeretnénk generálni, többször kell megismételnünk a folyamatot, nem egyszerre fogjuk őket futtatni.

<h2>Használhatóság</h2>
A Használhatóság azt a felhasználói élmény minőségére utal a szoftver használata közben. Lényeges szempontja a hatékonyság és a felhasználó elégedettsége. 
A csv2rdf könyvtárt először mi is felhasználóként ismertük meg, a használathoz segítségül egy példa kódot kaptunk, és **ide jön Jaki véleménye**

<h2>Megbízhatóság</h2>
Azt határozza meg, hogy milyen valószínűséggel fut a szoftver adott ideig hiba nélkül előre meghatározott körülmények között. Ezt a tulajdonságot hosszú idő alatt mérik használat közben, és mivel esetünkben nem áll rendelkezésre az időtartam nem tudunk pontos értéket mérni. Tapasztalatunk szerint a szoftver mindig működött, ezért megbízhatónak ítéljük.

<h2>Karbantarthatóság</h2>
Egy szoftver karbantarthatósága azt jelzi, hogy mennyire egyszerű, vagy mennyi időt vesz igénybe a hibáit javítani, vagy egy részét lecserélni a teljesítmény növelésének érdekében. Százalékban mérjük, és általában hosszabb időtartam alatt, használat közben mérik. Mivel, ez esetünkben nem lehetséges, a projekt kis méretéből adódóan azt becsültük, hogy ha van egy hiba, akkor 90% valószínűséggel javítható a következő 8 órában.

<h2>Biztonság</h2>
A Biztonság az a jellemző, ami leírja, hogy a szoftverben lévő adatok mennyire védettek támadások vagy jogosulatlan hozzáférésekkel szemben.
A project biztonságát SonarClud segítségével ellenőriztük, ami nem talált benne bugot, code smellt, sebezhetőséget vagy biztonsági rést.

