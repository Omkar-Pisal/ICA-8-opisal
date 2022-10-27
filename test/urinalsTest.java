import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class urinalsTest {
    @Test
    @DisplayName("====== Omkar Pisal == goodString =======")
    void stringCheck() {  // checks to see if valid string
        boolean check = urinals.goodString(" ");
        assertFalse(check);
    }
}