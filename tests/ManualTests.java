import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import org.apache.commons.io.FilenameUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.logging.Level;


public class ManualTests {
    @Test
    public void SuitableInput() {
        String[] args = { "examples/cars/template.ttl", "examples/cars/cars.csv", "tests/test.ttl"};
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(args).run();
    }

    @Test
    public void IncorrectInputName() {
        String[] args = {"examples/cars/template.ttl", "examples/cars/asd.csv", "tests/test.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }
    @Test
    public void IncorrectInputType() {
        String[] args = { "examples/cars/template.ttl", "examples/cars/cars.ttl", "tests/test.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }

    @Test
    public void IncorrectInput() {
        String[] args = { "examples/cars/template.ttl", "examples/cars/carsModified.csv", "tests/test.ttl"};
        Assertions.assertThrows(Exception.class, () -> {
            Cli.<Runnable>builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                    .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                    .build().parse(args).run();
        });
    }

    @Test
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
