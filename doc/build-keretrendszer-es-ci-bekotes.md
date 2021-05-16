Adta magát, hogy a projektben a GitHub Actions CI megoldását használjuk. Projektben mér konfigurálva volt az ant nevű build eszköz, ezért ehhez alkalmazkodva az alábbi lépések mentén elkészítettük a build, test és sonar targeteket tartalmazó CI folyamatot.


Az ant-tel nehézségeink támadtak, így kénytelenek voltunk a scriptet írni a tesztek megfelelő futtatásának biztosítására. Ez a repository root könyvtárban található test script. A tesztek ezzel a scripttel futtathatóak.

A teszfedettség méréshez a JaCoCo nevű eszközt választottuk, amihez elkészítettük a szükséges ant targetet, amit a CI folyamatok során meg is hívunk. 