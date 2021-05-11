import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.logging.Level;


public class ManualTests {
    @Test
    @DisplayName("Running where files are correct")
    public void SuitableInput() {
        String[] args = { "examples/cars/template.ttl", "examples/cars/cars.csv", "tests/test.ttl"};
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(args).run();
    }

    @Test
    @DisplayName("Running where input file does not exist")
    public void IncorrectInputName() {
        String[] args = {"examples/cars/template.ttl", "examples/cars/asd.csv", "tests/test.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }
    @Test
    @DisplayName("Running where input file's extension is not correct")
    public void IncorrectInputType() {
        String[] args = { "examples/cars/template.ttl", "examples/cars/cars.docx", "tests/test.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });

        String[] args1 = { "examples/cars/template.ttl", "examples/cars/cars.txt", "tests/test.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args1).run();
        });
    }

    @Test
    @DisplayName("Running where input file has incorrect content")
    public void IncorrectInput() {
        String[] args = { "examples/cars/template.ttl", "examples/cars/carsModified.csv", "tests/test.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }

    @Test
    @DisplayName("Running where the template file's content is incorrect")
    public void IncorrectTemplateContent() {
        String[] args = { "examples/cars/templateModified.ttl", "examples/cars/cars.csv", "tests/test.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }


    @Test
    @DisplayName("Running where the template file's content and the input file's content does not correlate")
    public void UnmatchingTemplateAndCsv() {
        String[] args = { "examples/cars/templateModified1.ttl", "examples/cars/cars.csv", "tests/test.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }

    @Test
    @DisplayName("Checking output file is generated and correct extension")
    public void CorrectOutput() {
        String[] args = { "examples/cars/template.ttl", "examples/cars/cars.csv", "tests/test.ttl"};
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(args).run();

        File file = new File("tests/test.ttl");
        Assertions.assertTrue(file.exists());
        Assertions.assertEquals("ttl", FilenameUtils.getExtension(file.getName()));
    }
}
