A statikus analízishez már a laborokon megismert SonarLint programot választottuk. Ez a program számos hibát és figyelmeztetést jelzett számunkra, melyeket közül az összes relevánsat kijavítotottuk és a javítások minőségét, helyességét egymásnak leellenőriztük.

A program által feldobott hibákat, figyelmeztetéseket 5 nagy csopoortra lehet bontani.

**1.**
Az első a kivételekkel kapcsolatos. Számos helyen írta a SonarLint, hogy az általános Java kivételek helyett saját kivételeket kell használni, mivel azok jobban a "testre szabhatók", sokkal specifikusabb üzeneteket, pontosabb hibameghatározásokat tudunk kiírni a felhasználóknak, fejlesztőknek. Ezek közül a hibák közül kijavítottunk párat, nem az összeset, hiszen azokat teljesen analóg módon kellett volna csinálni a többihez képest. A megoldás az volt, hogy létrehozunk saját kivétel osztályokat és azokat az adott kivétel funkciója szerint implementáljuk és ezeket a specifikus kivételeket használjuk a kód többi részén.

**2.**
A feltételes operátor egymásba ágyazására is jelzett hibát. A kód így szinte olvashatatlan, nehezen érthető volt, ezért egy if-else blokkba "kicsomagoltuk" a feltételes operátoros kifejezés külső részét, így már sokkal olvashatóbb lett a kód.

**3.**
A Java konvencióinak be nem tartásáért is kaptunk figyelmeztetéseket. Az osztályok deklarálásánál a static és abstract kulcsszavak voltak rossz sorrendben, ezeket javítottuk.
