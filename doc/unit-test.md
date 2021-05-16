A projekthez készítettünk unit teszteket, amelyek  /src/test mappában találhatóak. A tesztekben a könyvtár belső működését teszteltük különböző konverziókon kersztül junit használatával. 

A következő eseteket tesztelik a junit-ot használó unit tesztek:
    - One letter string to char conversion should work
    - Multiple letter to char conversion should fail
    - Empty string to char conversion should fail
    - Test FAIL_ON_UNKNOWN_DATATYPES default configuration should be false
    - Test FAIL_ON_UNKNOWN_LANGUAGES default configuration should be false
    - Running with the example files should succeed
    - Checking output file after run should succeed
    - Running with non-existent files should fail


Mindegyik teszt között elvégezzük a keletkezett input és output fileok takarítását, ami biztosítja, hogy a tesztek ne legyenek egymásra hatással.