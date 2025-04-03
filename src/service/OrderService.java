package service;

import model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * service class responsible for managing Purchase Orders.
 *
 * handles the creation, retrieval, and listing of purchase orders.
 *
 * integrates with Inventory and NotificationHandler to automate reorders
 * and notify relevant stakeholders.
 */
public class OrderService {
    private final Map<String, PurchaseOrder> purchaseOrders;    // stores purchase orders by order ID
    private final Inventory inventory;                         // reference to Inventory
    private final NotificationHandler notificationHandler;      // notification handler instance

    /**
     * constructor initializes order service with inventory and notification handler.
     *
     * @param inventory Reference to Inventory instance.
     */
    public OrderService(Inventory inventory) {
        this.purchaseOrders = new HashMap<>();
        this.inventory = inventory;
        this.notificationHandler = NotificationHandler.getInstance(); // singleton
    }

    /**
     * creates and processes a new purchase order for a specified item.
     * notifies both Supplier and Inventory Manager roles.
     *
     * @param itemName Name of the item to reorder.
     * @param quantity Quantity to be ordered.
     */
    public void createOrder(String itemName, int quantity) {
        InventoryItem item = inventory.findItemByName(itemName);
        if (item == null) {
            System.out.println("Item not found in inventory.");
            return;
        }

        // create supplier object for the order
        Supplier supplier = new Supplier(
                "S001",
                item.getSupplier(),
                "contact@" + item.getSupplier().toLowerCase() + ".com"
        );

        // generate unique order ID and create purchase order
        String orderId = IdentificationGenerator.generateUniqueID();
        PurchaseOrder order = PurchaseOrderFactory.createPurchaseOrder(orderId, itemName, quantity, supplier);
        purchaseOrders.put(orderId, order);

        // notify relevant user roles
        notificationHandler.notifyUserRole("Order created for: " + itemName + " Quantity: " + quantity, UserRole.SUPPLIER);
        notificationHandler.notifyUserRole("Order created for: " + itemName + " Quantity: " + quantity, UserRole.INVENTORY_MANAGER);
    }

    /**
     * retrieves a purchase order by its ID.
     *
     * @param orderID unique ID of the order.
     * @return PurchaseOrder object if found, otherwise null.
     */
    public PurchaseOrder getOrder(String orderID) {
        return purchaseOrders.get(orderID);
    }

    /**
     * lists all existing purchase orders.
     * prints details of each order to the console.
     */
    public void listOrders() {
        if (purchaseOrders.isEmpty()) {
            System.out.println("No purchase orders available.");
            return;
        }
        for (PurchaseOrder order : purchaseOrders.values()) {
            System.out.println(order);
        }
    }

    /**
     * returns all purchase orders.
     *
     * @return Map of order ID to PurchaseOrder.
     */
    public Map<String, PurchaseOrder> getAllOrders() {
        return purchaseOrders;
    }
}