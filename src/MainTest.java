import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testCapital() {
        assertTrue(Main.capital("Valid"));
        assertFalse(Main.capital("invalid"));
    }

    @Test
    public void testQuotation() {
        assertTrue(Main.quotation("This sentence has even quotes."));
        assertFalse(Main.quotation("This sentence has odd quotes\""));
    }

    @Test
    public void testEndsWith() {
        assertTrue(Main.endsWith("This ends with a period."));
        assertTrue(Main.endsWith("Does this end with a question mark?"));
        assertTrue(Main.endsWith("Exclaim!"));
        assertFalse(Main.endsWith("Invalid sentence"));
    }

    @Test
    public void testPeriod() {
        assertTrue(Main.period("This ends with a single period."));
        assertFalse(Main.period("This ends with multiple periods..."));
    }

    @Test
    public void testThirteen() {
        assertTrue(Main.thirteen("The number is 13."));
        assertFalse(Main.thirteen("The number is 5."));
    }

    @Test
    public void testRetrieveCount() {
        assertEquals(3, Main.retrieveCount("abcabcabc", 'a'));
        assertEquals(2, Main.retrieveCount("xyzxyz", 'z'));
    }
}