package model;

import service.IdentificationGenerator;

/**
 * model class representing an inventory item.
 *
 * each item has a unique identifier, name, category type, quantity,
 * reorder threshold, unit price, and supplier information.
 *
 * also contains a pendingOrder flag to prevent duplicate automatic purchase orders.
 */
public class InventoryItem {
    private final String uniqueID;         // unique identifier for the item
    private final String name;             // item name
    private final CategoryType type;      // category type of the item
    private final int reorderThreshold;   // quantity threshold at which reorder is triggered
    private int quantity;                 // current stock quantity
    private double unitPrice;             // price per unit
    private final String supplier;       // supplier name
    private boolean pendingOrder;        // flag indicating if a reorder is already pending

    /**
     * constructor to initialize a new inventory item.
     * generates a unique ID automatically.
     *
     * @param name            name of the item.
     * @param quantity        initial stock quantity.
     * @param reorderThreshold reorder threshold for low stock.
     * @param unitPrice       unit price of the item.
     * @param supplier        supplier name.
     * @param type            category type of the item.
     */
    public InventoryItem(String name, int quantity, int reorderThreshold, double unitPrice, String supplier, CategoryType type) {
        this.uniqueID = IdentificationGenerator.generateUniqueID(); // Generates unique UUID
        this.name = name;
        this.type = type;
        this.reorderThreshold = reorderThreshold;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.supplier = supplier;
    }

    // ======= Getters =======

    /**
     * returns the unique ID of the item.
     */
    public String getUniqueID() {
        return uniqueID;
    }

    /**
     * returns the name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * returns the category type of the item.
     */
    public CategoryType getType() {
        return type;
    }

    /**
     * returns the current quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * returns the unit price of the item.
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * returns the reorder threshold for the item.
     */
    public int getReorderThreshold() {
        return reorderThreshold;
    }

    /**
     * returns the supplier name of the item.
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * returns whether a reorder is already pending for this item.
     */
    public boolean isPendingOrder() {
        return pendingOrder;
    }

    // ======= Setters =======

    /**
     * rpdates the quantity of the item.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * updates the unit price of the item.
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * sets the pending order status.
     * used to prevent duplicate reorder creation.
     */
    public void setPendingOrder(boolean pendingOrder) {
        this.pendingOrder = pendingOrder;
    }
}