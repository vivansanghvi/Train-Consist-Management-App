import java.util.*;

// Step 1: Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Step 2: Passenger Bogie Class with Validation
class PassengerBogie {
    String type;
    int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " Bogie - Capacity: " + capacity;
    }
}

// Step 3: Main Application
public class uc14 {
    public static void main(String[] args) {

        List<PassengerBogie> consist = new ArrayList<>();

        try {
            consist.add(new PassengerBogie("Sleeper", 72));
            consist.add(new PassengerBogie("AC Chair", 60));
            consist.add(new PassengerBogie("First Class", 50));

            // Invalid bogie (will throw exception)
            consist.add(new PassengerBogie("Sleeper", -10));

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nValid Bogies in Train:");
        for (PassengerBogie b : consist) {
            System.out.println(b);
        }
    }
}import java.util.*;

// Step 1: Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Step 2: Passenger Bogie Class with Validation
class PassengerBogie {
    String type;
    int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return type + " Bogie - Capacity: " + capacity;
    }
}

// Step 3: Main Application
public class uc14 {
    public static void main(String[] args) {

        List<PassengerBogie> consist = new ArrayList<>();

        try {
            consist.add(new PassengerBogie("Sleeper", 72));
            consist.add(new PassengerBogie("AC Chair", 60));
            consist.add(new PassengerBogie("First Class", 50));

            // Invalid bogie (will throw exception)
            consist.add(new PassengerBogie("Sleeper", -10));

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nValid Bogies in Train:");
        for (PassengerBogie b : consist) {
            System.out.println(b);
        }
    }
}