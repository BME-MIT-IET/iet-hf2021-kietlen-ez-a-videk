**Notes:**
teljesítmény, stresszteszt, biztonság, használhatóság
Performance and scalability.
Portability and compatibility
Reliability, availability, maintainability
Security
Localization
**A vastagbetűset még be kell írni**

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
A csv2rdf könyvtárt először mi is felhasználóként ismertük meg, a használathoz segítségül egy példa kódot kaptunk, és **ide jön a véleménye a használhatóságról annak az embernek aki használja**

<h2>Megbízhatóság</h2>
Azt határozza meg, hogy milyen valószínűséggel fut a szoftver adott ideig hiba nélkül előre meghatározott körülmények között.

**(Hagyományos mérése:
valószínűség, százalékban mérjük
For instance, if the system has 85 percent reliability for a month, this means that during this month, under normal usage conditions, there’s an 85 percent chance that the system won’t experience critical failure.
Más opciók:
-count the number of critical bugs found in production for some period of time
(bug számoláshoz jó a bugzilla)
-calculate a mean time to failure
)**

<h2>Karbantarthatóság</h2>
Egy szoftver karbantarthatósága azt jelzi, hogy mennyire egyszerű, vagy mennyi időt vesz igénybe a hibáit javítani, vagy egy részét lecserélni a teljesítmény növelésének érdekében. Százalékban mérjük, és esetünkben, **ha van egy hiba, akkor X% az esély, hogy javítható a következő X órában.**

<h2>Biztonság</h2>
A Biztonság az a jellemző, ami leírja, hogy a szoftverben lévő adatok mennyire védettek támadások vagy jogosulatlan hozzáférésekkel szemben.
**Ha minden igaz sonarcloudban ottvan **

