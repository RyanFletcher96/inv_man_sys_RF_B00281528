package observer;

import model.UserRole;

/**
 * concrete Observer class for the Supplier role.
 *
 * implements the StockObserver interface to receive notifications
 * related to stock level changes and purchase orders.
 *
 * alerts generated by this observer are intended for Suppliers only.
 */
public class SupplierObserver implements StockObserver {

    /**
     * handles the notification message when stock changes or orders are placed.
     * displays an alert message specifically for suppliers.
     *
     * @param message the notification message.
     */
    @Override
    public void update(String message) {
        System.out.println("Supplier Alert: " + message);
    }

    /**
     * returns the user role associated with this observer.
     * used for role-based notification filtering.
     *
     * @return UserRole.SUPPLIER
     */
    @Override
    public UserRole getRole() {
        return UserRole.SUPPLIER;
    }
}