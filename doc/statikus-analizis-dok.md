A statikus analízishez már a laborokon megismert SonarLint plugint választottuk. Ez a plugin számos hibát és figyelmeztetést jelzett számunkra, melyeket közül az összes relevánsat kijavítotottuk és a javítások minőségét, helyességét egymásnak leellenőriztük.

A program által feldobott hibákat, figyelmeztetéseket 5 nagy csopoortra lehet bontani.

**1.**
Az első a kivételekkel kapcsolatos. Számos helyen írta a SonarLint, hogy az általános Java kivételek helyett saját kivételeket kell használni, mivel azok jobban a "testre szabhatók", sokkal specifikusabb üzeneteket, pontosabb hibameghatározásokat tudunk kiírni a felhasználóknak, fejlesztőknek. Ezek közül a hibák közül kijavítottunk párat, nem az összeset, hiszen azokat teljesen analóg módon kellett volna csinálni a többihez képest. A megoldás az volt, hogy létrehozunk saját kivétel osztályokat és azokat az adott kivétel funkciója szerint implementáljuk és ezeket a specifikus kivételeket használjuk a kód többi részén.

**2.**
A feltételes operátor egymásba ágyazására is jelzett hibát. A kód így szinte olvashatatlan, nehezen érthető volt, ezért egy if-else blokkba "kicsomagoltuk" a feltételes operátoros kifejezés külső részét, így már sokkal olvashatóbb lett a kód.

**3.**
Egy másik csoportba az apró hibák tartoznak. Például a Java konvencióinak be nem tartásáért is kaptunk figyelmeztetéseket. Az osztályok deklarálásánál a static és abstract kulcsszavak voltak rossz sorrendben, ezeket javítottuk. A main függvényre is kaptunk figyelmeztetést, itt csak a kivétel "eldobását" kellett kitörölni, hiszen a függvényen belül minden alapból try-catch blokkban van.

**4.**
További javított SonarLint figyelmeztetés volt a System.out típusú log üzenetek felváltása valamilyen Logger objektummal. Itt a java.util.logging.Logger osztályt használtuk a logolásra, és az információs jellegű logüzenetek INFO szintű logokkal váltottuk fel.

**5.**
Az eredeti com.google.common.base.Charsets.UTF_8 típusú charset-et lecseréltük java.nio.charset.StandardCharsets.UTF_8 charsetre.

**6.**
A java.nio.file.Files.delete() metódus használata a tesztek utáni kimeneti fájlok törlésekor.
