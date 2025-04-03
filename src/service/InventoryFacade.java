package service;

import model.CategoryType;
import model.InventoryItem;
import observer.InventoryManagerObserver;
import observer.SupplierObserver;

/**
 * facade class providing a simplified interface for inventory operations.
 *
 * acts as a single entry point for adding items, updating stock, and displaying inventory.
 *
 * also responsible for registering notification observers.
 * implements the **Facade Pattern** to hide complex subsystem interactions.
 */
public class InventoryFacade {
    private final Inventory inventory;                           // reference to Inventory (Singleton)
    private final NotificationHandler notificationHandler;       // notification handler instance

    /**
     * constructor initializes Inventory and NotificationHandler.
     * also registers observers for role-based notifications.
     */
    public InventoryFacade() {
        this.inventory = Inventory.getInstance();
        this.notificationHandler = NotificationHandler.getInstance();

        // register observers for notifications
        notificationHandler.addObserver(new InventoryManagerObserver());
        notificationHandler.addObserver(new SupplierObserver());
    }

    /**
     * adds an item to the inventory.
     * if item already exists, increases its quantity instead.
     * sends a notification after item addition or stock update.
     *
     * @param name             name of the item.
     * @param category         category type of the item.
     * @param quantity         quantity to be added.
     * @param reorderThreshold reorder threshold for the item.
     * @param unitPrice        unit price of the item.
     * @param supplier         supplier name.
     */
    public void addItem(String name, CategoryType category, int quantity, int reorderThreshold, double unitPrice, String supplier) {
        InventoryItem existing = inventory.findItemByName(name);
        if (existing != null) {
            // if item already exists then increase quantity
            updateItemQuantity(name, existing.getQuantity() + quantity);
            notificationHandler.sendNotification("Stock updated for: " + name);
        } else {
            // if new item then create and add
            InventoryItem item = InventoryItemFactory.createItem(name, quantity, reorderThreshold, unitPrice, supplier, category);
            inventory.addItem(item);
            notificationHandler.sendNotification("Item added: " + name);
        }
    }

    /**
     * updates the quantity of an existing inventory item.
     * also prints an update message.
     *
     * @param itemName Name of the item.
     * @param quantity New quantity value.
     */
    public void updateItemQuantity(String itemName, int quantity) {
        inventory.updateItemQuantity(itemName, quantity);
        System.out.println("Item updated: " + itemName + " Qty: " + quantity);
    }

    /**
     * displays all items currently in the inventory.
     * prints item name, quantity, category, and unique ID.
     */
    public void showAllItems() {
        System.out.println("Inventory Items:");
        for (InventoryItem item : inventory.getAllItems()) {
            System.out.println("Name: " + item.getName() + " | Qty: " + item.getQuantity() +
                    " | Category: " + item.getType() + " | ID: " + item.getUniqueID());
        }
    }
}