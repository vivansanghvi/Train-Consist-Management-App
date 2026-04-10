import java.util.*;

public class uc17 {

    // Method to sort bogie names
    public static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }

    public static void main(String[] args) {

        // Step 1: Input array
        String[] bogies = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogies));

        // Step 2: Sorting using Arrays.sort()
        sortBogieNames(bogies);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(bogies));
    }
}



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BogieNameSortAppTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};
        BogieNameSortApp.sortBogieNames(arr);

        assertArrayEquals(
                new String[]{"AC Chair","First Class","General","Luxury","Sleeper"},
                arr
        );
    }

    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury","General","Sleeper","AC Chair"};
        BogieNameSortApp.sortBogieNames(arr);

        assertArrayEquals(
                new String[]{"AC Chair","General","Luxury","Sleeper"},
                arr
        );
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"AC Chair","First Class","General"};
        BogieNameSortApp.sortBogieNames(arr);

        assertArrayEquals(
                new String[]{"AC Chair","First Class","General"},
                arr
        );
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper","AC Chair","Sleeper","General"};
        BogieNameSortApp.sortBogieNames(arr);

        assertArrayEquals(
                new String[]{"AC Chair","General","Sleeper","Sleeper"},
                arr
        );
    }

    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Sleeper"};
        BogieNameSortApp.sortBogieNames(arr);

        assertArrayEquals(
                new String[]{"Sleeper"},
                arr
        );
    }
}