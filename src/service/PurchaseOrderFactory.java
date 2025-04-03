package service;

import model.PurchaseOrder;
import model.Supplier;
import java.util.Date;

/**
 * factory class responsible for creating PurchaseOrder objects.
 *
 * implements the **Factory Pattern** to encapsulate the creation logic
 * for purchase orders, improving flexibility and maintainability.
 */
public class PurchaseOrderFactory {

    /**
     * creates a new PurchaseOrder instance with the provided details.
     *
     * sets the order date to the current date and the initial status to "Pending".
     *
     * @param orderID   Unique identifier for the purchase order.
     * @param itemName  Name of the item being ordered.
     * @param quantity  Quantity of the item to be ordered.
     * @param supplier  Supplier associated with the order.
     * @return A new PurchaseOrder instance.
     */
    public static PurchaseOrder createPurchaseOrder(String orderID, String itemName, int quantity, Supplier supplier) {
        return new PurchaseOrder(orderID, itemName, quantity, supplier, new Date(), "Pending");
    }
}