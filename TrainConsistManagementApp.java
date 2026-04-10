import java.util.*;

public class uc18 {

    // Linear Search Method
    public static boolean searchBogie(String[] bogieIds, String key) {

        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true; // Match found → early termination
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        // Step 1: Input array (unsorted bogie IDs)
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchKey = "BG309";

        System.out.println("Searching for: " + searchKey);

        // Step 2: Perform search
        boolean found = searchBogie(bogies, searchKey);

        // Step 3: Display result
        if (found) {
            System.out.println("Bogie found!");
        } else {
            System.out.println("Bogie not found.");
        }
    }
}





















import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BogieSearchAppTest {

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(BogieSearchApp.searchBogie(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(BogieSearchApp.searchBogie(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(BogieSearchApp.searchBogie(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(BogieSearchApp.searchBogie(arr, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};

        assertTrue(BogieSearchApp.searchBogie(arr, "BG101"));
    }
}

