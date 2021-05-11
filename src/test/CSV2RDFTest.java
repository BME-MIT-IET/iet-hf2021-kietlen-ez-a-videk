package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openrdf.rio.ParserConfig;
import org.openrdf.rio.helpers.BasicParserSettings;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Assertions;


import static org.junit.jupiter.api.Assertions.*;


public class CSV2RDFTest {

    private CSV2RDF csv2rdf;
    private static Logger logger = Logger.getLogger(CSV2RDFTest.class.getName());
    private String outputFile = "cars.ttl";
    private final String exampleInputTtl = "examples/cars/template.ttl";
    private final String exampleInputCsv = "examples/cars/cars.csv";



    @BeforeEach
    public void initEach(){
        this.csv2rdf = new CSV2RDF();
        logger.info("New CSV2RDF object has been initialized.");
    }

    @AfterEach
    public void cleanup(){
        File fileToCheck = new File(this.outputFile);
        try {
            if (fileToCheck.exists()) {
                java.nio.file.Files.delete(fileToCheck.toPath());
                logger.log(Level.INFO, "Output file deleted: {0}", fileToCheck.getName());
            }
        }catch (Exception e){
            logger.log(Level.WARNING , "Failed to delete output file: {0}", fileToCheck.getName());
        }
    }

    @Test
    @DisplayName("One letter string to char conversion should work")
    void testToCharWithSingleChar() {
        assertEquals('a', CSV2RDF.toChar("a"),
                "Simple to chart conversion should work");
    }

    @Test
    @DisplayName("Multiple letter to char conversion should fail")
    void testToCharWithMultipleChars() {
        assertThrows(IllegalArgumentException.class, () -> {
            CSV2RDF.toChar("abc");
        });
    }

    @Test
    @DisplayName("Empty string to char conversion should fail")
    void testToCharWithEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            CSV2RDF.toChar("");
        });
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
    @DisplayName("Running with the example files should succeed")
    void testRun() {
        ArrayList<String> files = new ArrayList<>();
        files.add(exampleInputTtl);
        files.add(exampleInputCsv);
        files.add(outputFile);
        this.csv2rdf.files = files;
        this.csv2rdf.run();
    }

    @Test
    @DisplayName("Checking output file after run should succeed")
    void testOutputFileAfterRun() {
        ArrayList<String> files = new ArrayList<>();
        files.add(exampleInputTtl);
        files.add(exampleInputCsv);
        files.add(this.outputFile);
        this.csv2rdf.files = files;
        this.csv2rdf.run();
        File outputFilename = new File(this.outputFile);
        assertEquals(true,outputFilename.exists());
    }

    @Test
    @DisplayName("Running with non-existent files should fail")
    void testRunWithNonExistingFiles() {
        ArrayList<String> files = new ArrayList<>();
        files.add("non-existent-file1");
        files.add("non-existent-file2");
        files.add(this.outputFile);
        this.csv2rdf.files = files;

        assertThrows(Exception.class, () -> {
            this.csv2rdf.run();
        });
    }

    @Test
    @DisplayName("Running where files are correct")
    public void suitableInput() {
        String[] args = { exampleInputTtl, exampleInputCsv, "cars.ttl"};
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(args).run();
    }

    @Test
    @DisplayName("Running where input file does not exist")
    public void incorrectInputName() {
        String[] args = {exampleInputTtl, "examples/cars/asd.csv", "cars.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }
    @Test
    @DisplayName("Running where input file's extension is not correct")
    public void incorrectInputType() {
        String[] args = { exampleInputTtl, "examples/cars/cars.docx", "cars.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }

    @Test
    @DisplayName("Running where input file has incorrect content")
    public void incorrectInput() {
        String[] args = { exampleInputTtl, "examples/cars/carsModified.csv", "cars.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }

    @Test
    @DisplayName("Running where the template file's content is incorrect")
    public void incorrectTemplateContent() {
        String[] args = { "examples/cars/templateModified.ttl", exampleInputCsv, "cars.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }


    @Test
    @DisplayName("Running where the template file's content and the input file's content does not correlate")
    public void unmatchingTemplateAndCsv() {
        String[] args = { "examples/cars/templateModified1.ttl", exampleInputCsv, "cars.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }

    @Test
    @DisplayName("Checking output file is generated and correct extension")
    public void correctOutput() {
        String[] args = { exampleInputTtl, exampleInputCsv, "cars.ttl"};
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(args).run();

        File file = new File("cars.ttl");
        Assertions.assertTrue(file.exists());
        Assertions.assertEquals("ttl", FilenameUtils.getExtension(file.getName()));
    }

}
