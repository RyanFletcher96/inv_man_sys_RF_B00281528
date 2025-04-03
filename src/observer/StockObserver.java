package observer;

import model.UserRole;

/**
 * observer interface for the Inventory Management System.
 *
 * defines the contract for observers who wish to receive notifications
 * about stock level changes and purchase orders.
 *
 * implements the Observer Pattern to enable loose coupling between
 * the Inventory system and notification recipients.
 */
public interface StockObserver {

    /**
     * called when a stock-related event occurs.
     * each observer will handle the message according to their role.
     *
     * @param message the notification message.
     */
    void update(String message);

    /**
     * returns the user role associated with the observer.
     * used to filter and direct notifications to the correct recipients.
     *
     * @return UserRole of the observer.
     */
    UserRole getRole();
}