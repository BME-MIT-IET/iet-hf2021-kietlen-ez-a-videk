A statikus analízishez már a laborokon megismert SonarLint programot választottuk. Ez a program számos hibát és figyelmeztetést jelzett számunkra, melyeket közül az összes relevánsat kijavítotottuk és a javítások minőségét, helyességét egymásnak leellenőriztük.

A program által feldobott hibákat, figyelmeztetéseket 5 nagy csopoortra lehet bontani.

Az első a kivételekkel kapcsolatos. Számos helyen írta a SonarLint, hogy az általános Java kivételek helyett saját kivételeket kell használni, mivel azok jobban a "testre szabhatók", sokkal specifikusabb üzeneteket, pontosabb hibameghatározásokat tudunk kiírni a felhasználóknak, fejlesztőknek. Ezek közül a hibák közül kijavítottunk párat, nem az összeset, hiszen azokat teljesen analóg módon kellett volna csinálni a többihez képest.
