package test;

import model.CategoryType;
import model.InventoryItem;
import model.PurchaseOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.Inventory;
import service.OrderService;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit Test Class for OrderService functionality.
 *
 * follows the Given-When-Then testing structure and JUnit 5 framework.
 *
 * tests the creation and retrieval of purchase orders.
 */
class OrderServiceTest {

    private Inventory inventory;
    private OrderService orderService;

    /**
     * sets up a fresh Inventory and OrderService instance before each test.
     * ensures a clean and repeatable environment.
     */
    @BeforeEach
    void setUp() {
        inventory = Inventory.getInstance();
        inventory.getAllItems().clear(); // Reset inventory before each test
        orderService = new OrderService(inventory);
    }

    /**
     * GIVEN an item exists in the inventory,
     * WHEN an order is created for the item,
     * THEN the order should be stored in the order service.
     */
    @Test
    void shouldStoreOrderWhenItemExistsInInventory() {
        // Given
        inventory.addItem(new InventoryItem("HP Laptop", 2, 5, 999.99, "TechSupplier", CategoryType.ELECTRONICS));

        // When
        orderService.createOrder("HP Laptop", 10);

        // Then
        assertEquals(1, orderService.getAllOrders().size());
    }

    /**
     * GIVEN a valid order is created,
     * WHEN the order is retrieved by its ID,
     * THEN the correct order details should be returned.
     */
    @Test
    void shouldReturnCorrectOrderWhenRetrievedById() {
        // Given
        inventory.addItem(new InventoryItem("HP Laptop", 2, 5, 999.99, "TechSupplier", CategoryType.ELECTRONICS));
        orderService.createOrder("HP Laptop", 10);
        PurchaseOrder createdOrder = orderService.getAllOrders().values().stream().findFirst().orElse(null);
        assertNotNull(createdOrder);

        // When
        PurchaseOrder retrievedOrder = orderService.getOrder(createdOrder.getOrderID());

        // Then
        assertEquals(createdOrder, retrievedOrder);
    }
}