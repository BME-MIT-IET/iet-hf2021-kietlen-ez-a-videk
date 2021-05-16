<h1>Build keretrendszer és CI bekötés</h1>

<h2>Összefoglalás</h2>
Adta magát, hogy a projektben a GitHub Actions CI megoldását használjuk. Projektben már konfigurálva volt az ant nevű build eszköz, ezért ehhez alkalmazkodva az alábbi lépések mentén elkészítettük a build, test és sonar targeteket futtató stageket tartalmazó CI folyamatot. A master branchen és a létrehozott merge requestekre triggerelt pipeline az alábbi lépések mentén készül el.
<br>
<br>
<h2>Build</h2>
Kezdetben nehézségeink támadtak az ant használatával a gitlab actions pipelineokban, próbálkoztünk többféle custom konfigurációval, míg nem végül összeállt egy futó változat. <br>

<br>
<h2>Teszek futtatása</h2>
Az ant-tel ebben a lépésben is kisebb nehézségeink adódtak, így kénytelenek voltunk a scriptet írni a tesztek megfelelő futtatásának biztosítására. Ez a repository root könyvtárban található test script. A unit tesztek ezzel a scripttel futtathatóak localban, és a CI folyamatok is ezt használva futtatják a projekthez írt unit teszteket.
<br>
<br>
<h2>SonarQube analízis</h2>
A CI folyamatban a statikus analízis lépést is automatizáltuk a projektben az első lépések között, ezért a továbbiakban minden csapattak tudta használni merge request feladásakor. A code smellek mentén a reviewerek kérhettek változtatásokat, amiket minden esetben kis is javítottunk, így tartva karban a projekt kódbázisát.
