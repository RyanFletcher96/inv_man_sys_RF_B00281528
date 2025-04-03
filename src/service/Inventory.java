package service;

import model.InventoryItem;
import model.CategoryType;

import java.util.*;

/**
 * singleton class responsible for managing inventory items,
 * handling stock updates, and triggering automatic purchase orders
 * when stock levels fall below the reorder threshold.
 */
public class Inventory {
    private static Inventory instance;
    private final Map<String, InventoryItem> items;
    private final NotificationHandler notificationHandler;
    private final OrderService orderService;

    // private constructor to enforce Singleton pattern
    private Inventory() {
        items = new HashMap<>();
        notificationHandler = NotificationHandler.getInstance();
        orderService = new OrderService(this);
    }

    /**
     * returns the single instance of Inventory.
     * ensures only one instance exists (Singleton Pattern).
     */
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    /**
     * adds a new item to the inventory or updates quantity if item already exists.
     * triggers reorder evaluation after addition.
     *
     * @param item The InventoryItem to be added or updated.
     */
    public void addItem(InventoryItem item) {
        if (items.containsKey(item.getName())) {
            // if item exists, increase its quantity
            InventoryItem existing = items.get(item.getName());
            existing.setQuantity(existing.getQuantity() + item.getQuantity());

            // reset pendingOrder flag if stock is healthy
            if (existing.getQuantity() > item.getReorderThreshold()) {
                existing.setPendingOrder(false);
            }

            // prevent duplicate reorders
            if (!existing.isPendingOrder() && existing.getQuantity() <= item.getReorderThreshold()) {
                checkReorder(existing);
            }
        } else {
            // add new item to inventory
            items.put(item.getName(), item);

            // check if reorder is needed immediately
            if (!item.isPendingOrder() && item.getQuantity() <= item.getReorderThreshold()) {
                checkReorder(item);
            }
        }
    }

    /**
     * updates the quantity of an existing inventory item.
     * resets pendingOrder flag if stock replenished.
     * evaluates reorder condition.
     *
     * @param itemName    Name of the item to update.
     * @param newQuantity New stock quantity.
     */
    public void updateItemQuantity(String itemName, int newQuantity) {
        InventoryItem item = findItemByName(itemName);
        if (item != null) {
            item.setQuantity(newQuantity);

            // reset reorder flag if stock is healthy
            if (newQuantity > item.getReorderThreshold()) {
                item.setPendingOrder(false);
            }

            // re-evaluate reorder condition
            if (!item.isPendingOrder() && item.getQuantity() <= item.getReorderThreshold()) {
                checkReorder(item);
            }
        }
    }

    /**
     * checks if an item's stock is below the reorder threshold.
     * if so, triggers a purchase order and sends notifications.
     * ensures reorder happens only once per low stock event.
     *
     * @param item InventoryItem to check.
     */
    private void checkReorder(InventoryItem item) {
        if (item.isPendingOrder()) {
            return; // reorder already triggered
        }
        if (item.getQuantity() <= item.getReorderThreshold()) {
            System.out.println("Stock for " + item.getName() + " is at or below threshold.");
            notificationHandler.sendNotification("Low stock: " + item.getName() + " (Qty: " + item.getQuantity() + ")");
            orderService.createOrder(item.getName(), (item.getReorderThreshold() * 2)); // auto reorder logic
            item.setPendingOrder(true); // Prevent further reorders until stock is replenished
        }
    }

    /**
     * finds an inventory item by its name.
     *
     * @param name Name of the item.
     * @return InventoryItem if found, otherwise null.
     */
    public InventoryItem findItemByName(String name) {
        return items.get(name);
    }

    /**
     * retrieves the category type of a specific item.
     *
     * @param itemName Name of the item.
     * @return CategoryType if item exists, otherwise null.
     */
    public CategoryType getItemCategory(String itemName) {
        InventoryItem item = items.get(itemName);
        return (item != null) ? item.getType() : null;
    }

    /**
     * returns a collection of all inventory items.
     *
     * @return Collection of InventoryItem objects.
     */
    public Collection<InventoryItem> getAllItems() {
        return items.values();
    }
}