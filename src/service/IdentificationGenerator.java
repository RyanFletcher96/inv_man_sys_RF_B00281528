package service;

import java.util.UUID;

/**
 * utility class responsible for generating unique identifiers.
 *
 * used to generate IDs for Inventory Items and Purchase Orders.
 * simulates real-world barcodes or order reference numbers.
 */
public class IdentificationGenerator {

    /**
     * generates a unique ID.
     *
     * @return a randomly generated UUID as a String.
     */
    public static String generateUniqueID() {
        return UUID.randomUUID().toString();
    }
}