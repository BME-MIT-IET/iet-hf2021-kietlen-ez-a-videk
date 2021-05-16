# Building and CI

A GitHub Actions platformot használjuk a projekt CI rendszeréhez. A projektben már konfigurálva volt az apache ant build eszköz,
ezért ehhez alkalmazkodva ebben a build rendszerben hoztuk létre a test és sonar targeteket a CI pipelinehoz.

## Github Actions

A github actions alap beállítása triviális volt, mivel elérhető volt egy példa yaml config ant build rendszerhez. Ebben a lépésben még csak az előre definiált compile target lett beállítva.

## SonarCloud

A következő lépés a CI pipeline létrehozásában a SonarCloud statikus analízis platform bekötése volt.
Ez már nem volt triviális feladat, mivel a SonarCloud-on nem volt elérhető dokumentáció az ant rendszerhez való bekötéshez.
Ráadásul a projekt létrehozásnál a leírás következő támánként volt felsorolva:
1) maven
2) gradle
3) other

de az "other" opció nemvolt helyes megoldás az ant-hez.
A rendszer felépítéséhez a SonarQube dokumentációt használtam fel. Ebben a dokumentációban megtaláltam leírást maven, gradle és ant-hez is.
Ahhoz hogy a SonarQube-ban leírtakat fel tudjam használni a SonarCloud-hoz összehasonlítottam a SonarQube maven leírást a SonarCloud maven
leírással, és ugyanilyen formában a gradle-t, ezekből következtetve tudtam létrehozni az ant beállítását SonarCloudhoz.

## Tests

A teszt lefuttatások bekötése volt a legidőigényesebb feladat. Az első problémát az okozta, hogy a tesztek a JUnit több verzióját használták egyszerre, emellett nem használtak olyan engine könyvtárat, ami engedte volna a visszamenőleges verzió használatát. Legelőször ezért refactoráltam a teszteket, hogy konzisztensen a JUnit 5 verziót használják, és rendbetettem a könyvtár importálásokat.

A következő probléma a JUnit 5 és az ant rendszer összehangolása volt. Sehogyan nem akart sikerülni ennek a két rendszernek az összehangolása, azt ant és a JUnit 5 dokumentációjának is előről hátra elolvastam a releváns részeit többször. Eljutottam egy pontig, ahol abszolút minden leírásnak megfelelt a rendszer, minden lib a helyén volt, de egy értelmezhetetlen hibát kaptam, amire 2 találat volt google-ön, de egyetlen válasz sem érkezett rájuk. A megoldás az volt, hogy találtam egy repo-t, ahol volt egy példa ant+JUnit5 rendszer felállítva. Ebben a programban külön letöltötte az ant programot és egy "junit-platform-console-standalone" lib-et beadott neki (ahelyett a 6 lib helyett, amit én a dokumentáció alapján összegyűjtöttem). Ez alapján létrehoztam egy bash scriptet "test" néven, amely letölti az ant-et az előbb említett lib-bel a projekt mappába, ha nincsen még letöltve, és ezt az ant-et használva buildeli a test target-et.

Miután kész lett a test script kiegészítettem vele a CI pipeline-t.


## Tanulság

Ne használjunk ant-et.
