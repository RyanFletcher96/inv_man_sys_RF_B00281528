package service;

import model.CategoryType;
import model.InventoryItem;

/**
 * factory class responsible for creating InventoryItem objects.
 *
 * implements the **Factory Pattern** to encapsulate object creation logic.
 * this approach improves flexibility and makes the system easier to maintain
 * if item creation logic changes in the future.
 */
public class InventoryItemFactory {

    /**
     * creates a new InventoryItem with the provided details.
     *
     * @param name             Name of the item.
     * @param quantity         Initial stock quantity.
     * @param reorderThreshold Reorder threshold for the item.
     * @param unitPrice        Unit price of the item.
     * @param supplier         Supplier name.
     * @param type             Category type of the item.
     * @return A new InventoryItem instance.
     */
    public static InventoryItem createItem(String name, int quantity, int reorderThreshold, double unitPrice, String supplier, CategoryType type) {
        return new InventoryItem(name, quantity, reorderThreshold, unitPrice, supplier, type);
    }
}