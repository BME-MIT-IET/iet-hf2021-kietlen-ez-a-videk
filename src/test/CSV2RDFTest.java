package test;

import com.complexible.common.csv.CSV2RDF;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.openrdf.rio.ParserConfig;
import org.openrdf.rio.helpers.BasicParserSettings;

import static org.junit.jupiter.api.Assertions.*;

class CSV2RDFTest {

    private CSV2RDF csv2rdf;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeEach
    public void setUp() throws Exception{
         this.csv2rdf= new CSV2RDF();
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

}