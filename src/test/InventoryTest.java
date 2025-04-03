package test;

import model.CategoryType;
import model.InventoryItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.Inventory;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit Test Class for Inventory functionalities.
 *
 * follows the Given-When-Then testing structure and JUnit 5 framework.
 * tests key Inventory operations such as adding items, updating quantities,
 * and reorder threshold behaviour.
 */

class InventoryTest {

    private Inventory inventory;

    /**
     * sets up a fresh instance of Inventory before each test.
     * ensures all tests are independent and repeatable.
     */
    @BeforeEach
    void setUp() {
        inventory = Inventory.getInstance();
        inventory.getAllItems().clear(); // Reset state before each test
    }

    /**
     * GIVEN a new InventoryItem,
     * WHEN the item is added to the inventory,
     * THEN the item should be stored and retrievable.
     */
    @Test
    void shouldStoreItemInInventoryWhenAdded() {
        // Given
        InventoryItem item = new InventoryItem("HP Laptop", 1, 5, 999.99, "TechSupplier", CategoryType.ELECTRONICS);

        // When
        inventory.addItem(item);

        // Then
        assertNotNull(inventory.findItemByName("HP Laptop"));
    }

    /**
     * GIVEN an existing item in the inventory,
     * WHEN the item quantity is updated,
     * THEN the quantity should reflect the new value.
     */
    @Test
    void shouldUpdateItemQuantityCorrectlyWhenStockIsChanged() {
        // Given
        InventoryItem item = new InventoryItem("HP Laptop", 1, 5, 999.99, "TechSupplier", CategoryType.ELECTRONICS);
        inventory.addItem(item);

        // When
        inventory.updateItemQuantity("HP Laptop", 10);

        // Then
        assertEquals(10, inventory.findItemByName("HP Laptop").getQuantity());
    }

    /**
     * GIVEN a new item with quantity below reorder threshold,
     * WHEN the item is added to the inventory,
     * THEN a reorder should be triggered and pendingOrder flag set to true.
     */
    @Test
    void shouldTriggerReorderWhenQuantityIsBelowThreshold() {
        // Given
        InventoryItem item = new InventoryItem("HP Laptop", 1, 5, 999.99, "TechSupplier", CategoryType.ELECTRONICS);

        // When
        inventory.addItem(item);

        // Then
        assertTrue(inventory.findItemByName("HP Laptop").isPendingOrder());
    }
}