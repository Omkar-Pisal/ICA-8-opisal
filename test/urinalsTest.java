import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class urinalsTest {

    @Test
    @DisplayName("====== Omkar Pisal == Good String Method -> Empty string test =======")
    void checkEmptyString() {
        boolean check = urinals.goodString(" ");
        assertFalse(check);
    }

    @Test
    @DisplayName("====== Omkar Pisal == Good String Method -> good string test =======")
    void checkGoodString() {
        boolean check1 = urinals.goodString("010101");
        assertTrue(check1);
    }

    @Test
    @DisplayName("====== Omkar Pisal == Good String Method -> bad string test =======")
    void checkBadString() {
        boolean check2 = urinals.goodString("0101100");
        assertFalse(check2);
    }

    @Test
    @DisplayName("====== Omkar Pisal == Good String Method -> string length test =======")
    void checkStringLength() {
        boolean check1 = urinals.goodString("010101010101010101010101010101");
        assertFalse(check1);
    }

    @Test
    @DisplayName("====== Omkar Pisal == coutUrinals Method =======")
    void countUrinals() {
        int emptyUrinals = urinals.countUrinals("10001");
        assertEquals(1, emptyUrinals);
    }

}