Adta magát, hogy a projektben a GitHub Actions CI megoldását használjuk. Projektben mér konfigurálva volt az ant nevű build eszköz, ezért ehhez alkalmazkodva az alábbi lépések mentén elkészítettük a build, test és sonar targeteket tartalmazó CI folyamatot.



A teszfedettség méréshez a JaCoCo nevű eszközt választottuk, amihez elkészítettük a szükséges ant targetet, amit a CI folyamatok során meg is hívunk.