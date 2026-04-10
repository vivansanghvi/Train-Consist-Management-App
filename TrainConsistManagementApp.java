import java.util.*;

public class uc20 {

    // Search method with validation
    public static boolean searchBogie(String[] bogieIds, String key) {

        // Step 1: Fail-fast validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        // Step 2: Perform search (Linear Search)
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogies = {}; // Empty array (test case)

        try {
            boolean result = searchBogie(bogies, "BG101");
            System.out.println("Search Result: " + result);

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
}









import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BogieSearchWithValidationAppTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            BogieSearchWithValidationApp.searchBogie(arr, "BG101");
        });

        assertEquals("No bogies available for search", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101", "BG205"};

        assertDoesNotThrow(() -> {
            BogieSearchWithValidationApp.searchBogie(arr, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(BogieSearchWithValidationApp.searchBogie(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};

        assertFalse(BogieSearchWithValidationApp.searchBogie(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};

        assertTrue(BogieSearchWithValidationApp.searchBogie(arr, "BG101"));
    }
}
