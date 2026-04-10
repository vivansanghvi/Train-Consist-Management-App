import java.util.*;

// Step 1: Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Step 2: Goods Bogie Class
class uc15 {
    String shape;   // Rectangular / Cylindrical
    String cargo;   // Assigned cargo

    public uc15(String shape) {
        this.shape = shape;
    }

    // Step 3: Safe Cargo Assignment
    public void assignCargo(String cargoType) {
        try {
            // Unsafe condition
            if (shape.equalsIgnoreCase("Rectangular") &&
                    cargoType.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe: Cannot assign Petroleum to Rectangular bogie");
            }

            // Safe assignment
            this.cargo = cargoType;
            System.out.println("Cargo assigned successfully: " + cargoType);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Cargo assignment attempt completed.\n");
        }
    }

    public String getCargo() {
        return cargo;
    }

    public String getShape() {
        return shape;
    }
}

// Step 4: Main Application
public class CargoManagementApp {
    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe case
        b1.assignCargo("Petroleum");

        // Unsafe case
        b2.assignCargo("Petroleum");

        // Program continues
        b2.assignCargo("Grains");

        System.out.println("Program continues safely...");
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CargoManagementAppTest {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        assertDoesNotThrow(() -> {
            bogie.assignCargo("Petroleum");
        });

        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // Exception is handled internally, so no crash
        bogie.assignCargo("Petroleum");

        // Cargo should not be assigned
        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");  // unsafe
        bogie.assignCargo("Coal");       // safe after failure

        assertEquals("Coal", bogie.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // We can't directly assert finally block execution,
        // but we ensure method completes without interruption
        assertDoesNotThrow(() -> {
            bogie.assignCargo("Petroleum");
        });
    }
