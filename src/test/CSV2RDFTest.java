package test;

import com.complexible.common.csv.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.openrdf.rio.ParserConfig;
import org.openrdf.rio.helpers.BasicParserSettings;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


public class CSV2RDFTest {

    private CSV2RDF csv2rdf;
    private static Logger logger = Logger.getLogger(CSV2RDFTest.class.getName());
    private String outputFile = "cars.ttl";

    @BeforeEach
    public void initEach(){
        this.csv2rdf = new CSV2RDF();
        logger.info("New CSV2RDF object has been initialized.");
    }

    @AfterEach
    public void cleanup(){
        File fileToCheck = new File(this.outputFile);
        if(fileToCheck.exists()){
            if (fileToCheck.delete()) {
                logger.log(Level.INFO,"Output file deleted: {0}",  fileToCheck.getName());
            } else {
                logger.log(Level.WARNING,"Failed to delete output file: {0}",  fileToCheck.getName());
            }
        }
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    @DisplayName("One letter string to char conversion should work")
    void testToCharWithSingleChar() {
        assertEquals('a', CSV2RDF.toChar("a"),
                "Simple to chart conversion should work");
    }

    @Test
    @DisplayName("Multiple letter to char conversion should fail")
    void testToCharWithMultipleChars() {
        try {
            CSV2RDF.toChar("abc");
            Assert.fail();
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Empty string to char conversion should fail")
    void testToCharWithEmptyInput() {
        try {
            CSV2RDF.toChar("");
            Assert.fail();
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Test FAIL_ON_UNKNOWN_DATATYPES default configuration should be false")
    void testFailOnUnknownDataTypes() {
        ParserConfig config = CSV2RDF.getParserConfig();
        assertEquals(false, config.get(BasicParserSettings.FAIL_ON_UNKNOWN_DATATYPES));
    }

    @Test
    @DisplayName("Test FAIL_ON_UNKNOWN_LANGUAGES default configuration should be false")
    void testFailOnUnknownLanguages() {
        ParserConfig config = CSV2RDF.getParserConfig();
        assertEquals(false, config.get(BasicParserSettings.FAIL_ON_UNKNOWN_LANGUAGES));
    }

    @Test
    @DisplayName("Run method without any given arguments should fail")
    void testRunWithoutArguments() {
        try {
            this.csv2rdf.run();
            Assert.fail();
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Test
    @DisplayName("Running with the example files should succeed")
    void testRun() {
        ArrayList<String> files = new ArrayList<>();
        files.add("examples/cars/template.ttl");
        files.add("examples/cars/cars.csv");
        files.add(outputFile);
        this.csv2rdf.files = files;
        this.csv2rdf.run();
    }

    @Test
    @DisplayName("Checking output file after run should succeed")
    void testOutputFileAfterRun() {
        ArrayList<String> files = new ArrayList<>();
        files.add("examples/cars/template.ttl");
        files.add("examples/cars/cars.csv");
        files.add(this.outputFile);
        this.csv2rdf.files = files;
        this.csv2rdf.run();
        File outputFilename = new File(this.outputFile);
        assertEquals(true,outputFilename.exists());
    }

    @Test
    @DisplayName("Running with the example files should succeed")
    void testRunWithNonExistingFiles() {
        try {
            ArrayList<String> files = new ArrayList<>();
            files.add("examples/cars/template.tt");
            files.add("examples/cars/cars.cs");
            files.add(this.outputFile);
            this.csv2rdf.files = files;
            this.csv2rdf.run();
            Assert.fail();
        } catch (Exception e) {
            logger.info("Exception thrown, test succeeded.");
        }
    }


}