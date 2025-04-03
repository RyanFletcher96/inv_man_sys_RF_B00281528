package test;

import model.CategoryType;
import model.UserRole;
import service.InventoryFacade;
import service.NotificationHandler;

/**
 * this test harness only ensures it's working as expected with inputs.
 * it is not unit testing.
 */

public class TestHarness {
    public static void main(String[] args) {
        System.out.println("===== INVENTORY MANAGEMENT SYSTEM TEST HARNESS =====\n");

        // setup Notification Observers
        NotificationHandler notificationHandler = NotificationHandler.getInstance();

        // create Inventory Facade
        InventoryFacade facade = new InventoryFacade();

        System.out.println("\n--- Adding Items to Inventory ---");
        facade.addItem("HP Laptop", CategoryType.ELECTRONICS, 1, 5, 999.99, "TechSupplier");
        facade.addItem("HP Laptop", CategoryType.ELECTRONICS, 1, 5, 999.99, "TechSupplier");
        facade.addItem("Dell Laptop", CategoryType.ELECTRONICS, 10, 5, 899.99, "TechSupplier");

        System.out.println("\n--- Display All Items ---");
        facade.showAllItems();

        System.out.println("\n--- Updating Stock (simulate delivery) ---");
        facade.updateItemQuantity("HP Laptop", 20); // this should reset reorder flag

        System.out.println("\n--- Reducing Stock Below Threshold ---");
        facade.updateItemQuantity("HP Laptop", 4); // should trigger reorder

        System.out.println("\n--- Display All Items Again ---");
        facade.showAllItems();

        System.out.println("\n--- Role-Based Notifications ---");
        System.out.println("Notifications for Inventory Manager:");
        notificationHandler.notifyUserRole("Restock completed for HP Laptop", UserRole.INVENTORY_MANAGER);

        System.out.println("\nNotifications for Supplier:");
        notificationHandler.notifyUserRole("New Purchase Order for HP Laptop", UserRole.SUPPLIER);

        System.out.println("\n===== TEST HARNESS COMPLETE =====");
    }
}