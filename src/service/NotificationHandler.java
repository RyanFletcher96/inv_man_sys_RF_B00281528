package service;

import model.UserRole;
import observer.StockObserver;

import java.util.*;

/**
 * singleton class responsible for managing notifications in the Inventory Management System.
 *
 * implements the **Observer Pattern** to notify subscribed observers (Inventory Managers, Suppliers)
 * about stock level changes, purchase orders, and other events.
 */
public class NotificationHandler {
    private static NotificationHandler instance;            // singleton instance
    private final List<StockObserver> observers = new ArrayList<>(); // list of registered observers

    /**
     * private constructor to enforce Singleton pattern.
     * prevents external instantiation.
     */
    private NotificationHandler() { }

    /**
     * returns the singleton instance of NotificationHandler.
     *
     * @return NotificationHandler instance.
     */
    public static NotificationHandler getInstance() {
        if (instance == null) {
            instance = new NotificationHandler();
        }
        return instance;
    }

    /**
     * registers an observer to receive notifications.
     *
     * @param observer Observer to be added.
     */
    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    /**
     * removes an observer from receiving notifications.
     *
     * @param observer Observer to be removed.
     */
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    /**
     * sends a notification message to all registered observers.
     *
     * @param message The notification message.
     */
    public void sendNotification(String message) {
        notifyObservers(message);
    }

    /**
     * notifies all registered observers with the given message.
     *
     * @param message The notification message.
     */
    private void notifyObservers(String message) {
        for (StockObserver observer : observers) {
            observer.update(message);
        }
    }

    /**
     * sends a notification message to observers based on their user role.
     *
     * this supports role-based notification filtering.
     *
     * @param message The notification message.
     * @param role    The user role to notify.
     */
    public void notifyUserRole(String message, UserRole role) {
        for (StockObserver observer : observers) {
            if (observer.getRole() == role) {
                observer.update(message);
            }
        }
    }
}