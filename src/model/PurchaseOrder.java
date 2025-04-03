package model;

import java.util.Date;

/**
 * model class representing a Purchase Order in the system.
 *
 * each PurchaseOrder includes information about the ordered item,
 * quantity, supplier details, order date, and current status.
 */
public class PurchaseOrder {
    private final String orderID;     // unique identifier for the order
    private final String itemName;    // name of the item being ordered
    private final int quantity;       // quantity of item ordered
    private final Supplier supplier;  // supplier details
    private final Date orderDate;     // date the order was created
    private String status;            // current status of the order (e.g. Pending, Completed)

    /**
     * Constructor to create a new PurchaseOrder instance.
     *
     * @param orderID   unique identifier for the order.
     * @param itemName  name of the ordered item.
     * @param quantity  quantity of item ordered.
     * @param supplier  supplier details.
     * @param orderDate date of order creation.
     * @param status    current status of the order.
     */
    public PurchaseOrder(String orderID, String itemName, int quantity, Supplier supplier, Date orderDate, String status) {
        this.orderID = orderID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.supplier = supplier;
        this.orderDate = orderDate;
        this.status = status;
    }

    // ======= Getters =======

    /**
     * returns the unique ID of the purchase order.
     */
    public String getOrderID() {
        return orderID;
    }

    /**
     * returns the name of the item being ordered.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * returns the quantity of item ordered.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * returns the supplier associated with the order.
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * returns the date when the order was created.
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * returns the current status of the order.
     */
    public String getStatus() {
        return status;
    }

    // ======= Setter =======

    /**
     * updates the status of the purchase order.
     *
     * @param status new status to be set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    // ======= String Representation =======

    @Override
    public String toString() {
        return "Order ID: " + orderID +
                ", Item: " + itemName +
                ", Quantity: " + quantity +
                ", Supplier: " + supplier.getName() +
                ", Date: " + orderDate +
                ", Status: " + status;
    }
}